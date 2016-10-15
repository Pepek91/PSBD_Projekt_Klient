/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psbd.projekt.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import psbd.projekt.classes.Klient;
import psbd.projekt.model.SiecHoteli;

/**
 *
 * @author Michal
 */
public class MySql {

    private static MySql instane = new MySql();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs = null;

    MySql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String user = "root";
            String password = "projekt";
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost/psbd?useUnicode=true&characterEncoding=utf-8", user, password);
            System.out.println("MySQL connection OK");;
        } catch (Exception e) {
            e.printStackTrace();
            closeConnection();
            JOptionPane.showMessageDialog(null, "Brak połączenia z bazą danych! Program zostanie zamknięty!");
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return con;
    }

    // You need to close the resultSet
    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
        }
        System.out.println("MySQL connection closed!");
    }

    public void wyszukajPokoje(int iloscOs, String miejsce, Date dataOd, Date dataDo) {
        SiecHoteli siec = SiecHoteli.getInstance();
        StringBuilder sb = new StringBuilder("SELECT DISTINCT p.*, h.* ");
        sb.append("FROM pokoje AS p ");
        sb.append("INNER JOIN hotele AS h ON p.id_hotelu = h.id_hotelu ");
        sb.append("LEFT JOIN pokoje_rezerwacje AS pr ON pr.id_pokoju = p.id_pokoju ");
        sb.append("LEFT JOIN rezerwacje AS r ON r.id_rezerwacji = pr.id_rezerwacji ");
        sb.append("WHERE liczba_osob >=? ");
        sb.append("AND p.id_pokoju NOT IN ");
        sb.append("(SELECT pr2.id_pokoju FROM pokoje_rezerwacje AS pr2 \n" +
"INNER JOIN rezerwacje AS r2 ON r2.id_rezerwacji = pr2.id_rezerwacji\n" +
"WHERE \n" +
"((r2.data_rozpoczecia >= ? AND r2.data_rozpoczecia<?) OR (r2.data_zakonczenia >? AND r2.data_zakonczenia<=?) OR (r2.data_zakonczenia >? AND r2.data_zakonczenia<?))"
                + " AND status !='nieaktywna')");
        if (!miejsce.equals("")) {
            sb.append("AND adres_miasto LIKE ? ");
        }
        int index = 0;
        try {
            ps = con.prepareStatement(sb.toString());
            ps.setInt(++index, iloscOs);
            if (!miejsce.equals("")) {//michal ppk
                ps.setString(++index, "%" + miejsce + "%");
            }
            ps.setDate(++index, dataOd);
            ps.setDate(++index, dataDo);
            ps.setDate(++index, dataOd);
            ps.setDate(++index, dataDo);
            ps.setDate(++index, dataDo);
            ps.setDate(++index, dataOd);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                siec.addPokoj(rs.getInt("id_pokoju"), rs.getInt("numer_pokoju"), rs.getInt("cena"),
                        rs.getShort("standard"), rs.getShort("liczba_osob"), rs.getShort("liczba_pomieszczen"),
                        rs.getShort("liczba_gwiazdek"), rs.getString("nazwa"), rs.getInt("id_hotelu"));
            }
            Utils.dataOd = dataOd;
            Utils.dataDo = dataDo;
        } catch (SQLException ex) {
        }
    }

    public static MySql getInstance() {
        return instane;
    }

    public int addRezerwacje(Object[][] rezerwacje) {
        int id_rezerwacji = 0;
        Klient klient = Klient.getInstance();
        int znizka = klient.getIloscPobytow() * 2;
        if (znizka > 20) {
            znizka = 20;
        }
        try {
            ps = con
                    .prepareStatement("INSERT INTO rezerwacje VALUES (default, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, klient.getId());
            ps.setDate(2, Utils.dataOd);
            ps.setDate(3, Utils.dataOd);
            ps.setString(4, "aktywna");
            ps.setInt(5, znizka);
            ps.setInt(6, 0);

            int ilosc = ps.executeUpdate();

            if (ilosc == 1) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    id_rezerwacji = rs.getInt(1);
                    int size = rezerwacje.length;
                    for (int i = 0; i < size; ++i) {
                        dodajPokojDoRezeracji(rezerwacje[i], id_rezerwacji);
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_rezerwacji;
    }

    private void dodajPokojDoRezeracji(Object[] object, int id) {
        try {
            ps = con
                    .prepareStatement("INSERT INTO pokoje_rezerwacje VALUES (?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setInt(2, (int) object[0]);
            ps.setFloat(3, (float) object[2]);
            ps.setInt(4, (int) object[1]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<ArrayList<Object>> getNiezrealizowane(int idRezerwacji) {
        ArrayList<ArrayList<Object>> rezerwacje = new ArrayList<ArrayList<Object>>();

        StringBuilder sb = new StringBuilder("SELECT DISTINCT p.*, h.*, r.*, pr.*");
        sb.append("FROM pokoje AS p ");
        sb.append("INNER JOIN hotele AS h ON p.id_hotelu = h.id_hotelu ");
        sb.append("INNER JOIN pokoje_rezerwacje AS pr ON p.id_pokoju = pr.id_pokoju ");
        sb.append("INNER JOIN rezerwacje AS r ON r.id_rezerwacji = pr.id_rezerwacji ");
        sb.append("WHERE r.id_klienta =? AND status ='aktywna'");
        int index = 0;
        try {
            ps = con.prepareStatement(sb.toString());
            ps.setInt(++index, Klient.getInstance().getId());
            System.out.println(ps);//michal ppk
            rs = ps.executeQuery();
            while (rs.next()) {
                ArrayList<Object> pokoj = new ArrayList<Object>();
                pokoj.add(rs.getInt("id_rezerwacji"));
                pokoj.add(rs.getString("nazwa"));
                pokoj.add(rs.getInt("standard"));
                pokoj.add(rs.getInt("liczba_gwiazdek"));
                pokoj.add(rs.getString("id_hotelu"));
                rezerwacje.add(pokoj);
            }
        } catch (SQLException ex) {
        }
        return rezerwacje;
    }

    public void anulujRezerwacje(int id_rezerwacji) {
        try {
            ps = con
                    .prepareStatement("UPDATE rezerwacje SET status ='nieaktywna' WHERE id_rezerwacji =?");
            ps.setInt(1, id_rezerwacji);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
