package com.revature.repository;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReimbursementDAO {

    UserDAO u = new UserDAO();

    static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


    public static Reimbursement getById(int id) {
        String sql = "select * from requests where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reimbursement r = new Reimbursement(
                        rs.getInt("id"),
                        rs.getString("status"),
                        (rs.getString("author") == null) ? null : UserDAO.getByUsername(rs.getString("author")),
                        (rs.getString("resolver") == null) ? null : UserDAO.getByUsername(rs.getString("resolver")),
                        rs.getDouble("amount"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getString("justification"),
                        rs.getString("title")
                );
                return r;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /*public static Reimbursement getByUser(String author){
        String sql = "select * from requests where author= ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, author);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reimbursement r = new Reimbursement(
                        rs.getInt("id"),
                        rs.getString("status"),
                        (rs.getString("author") == null) ? null : UserDAO.getByUsername(rs.getString("author")),
                        (rs.getString("resolver") == null) ? null : UserDAO.getByUsername(rs.getString("resolver")),
                        rs.getDouble("amount"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getString("justification"),
                        rs.getString("title")
                );

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /*public static Reimbursement add(Reimbursement reimbursement) {

        String sql = "insert into requests (id,status,author,resolver,amount,date,location, justification, title) values (default, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbursement.getId());
            ps.setString(2, reimbursement.getStatus());
            ps.setString(4, String.valueOf(reimbursement.getResolver()));
            ps.setDouble(5, reimbursement.getAmount());
            ps.setString(6, reimbursement.getDate());
            ps.setString(7, reimbursement.getLocation());
            ps.setString(8, reimbursement.getJustification());
            ps.setString(9, reimbursement.getTitle());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reimbursement.setId(rs.getInt("id"));
                return reimbursement;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

      /*public Reimbursement create(Reimbursement reimbursementToRequest){
        return reimbursementToRequest;
      }*/

    public static Reimbursement create(Reimbursement unprocessedReimbursement) {
        String sql = "insert into requests (id, status, author, amount, date, location,justification, title) values (default, ?, ?, ?, ?, ?, ?, ?) returning *";//+ " select * from inserted_request left join requests on(users.id=requests.author)";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1, unprocessedReimbursement.getId());
            ps.setString(1, unprocessedReimbursement.getStatus());
            ps.setInt(2, unprocessedReimbursement.getAuthor().getId());
            //ps.setInt(3, unprocessedReimbursement.getResolver().getId());
            ps.setDouble(3, unprocessedReimbursement.getAmount());
            ps.setString(4, unprocessedReimbursement.getDate());
            ps.setString(5, unprocessedReimbursement.getLocation());
            ps.setString(6, unprocessedReimbursement.getJustification());
            //ps.setString(9, unprocessedReimbursement.getGrade());
            ps.setString(7, unprocessedReimbursement.getTitle());


            ps.executeUpdate();
            return unprocessedReimbursement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unprocessedReimbursement;
    }

    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    } // remember collection empty list


    /*public Reimbursement update(Reimbursement unprocessedReimbursement) {
        return null;
    }*/



    public static List<Reimbursement> getAll() {
        List<Reimbursement> reimbursements = new ArrayList<>();
        String sql = "select * from requests";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reimbursement r = new Reimbursement(
                        rs.getInt("id"),
                        rs.getString("status"),
                        (rs.getString("author") == null) ? null : UserDAO.getByUsername(rs.getString("author")),
                        (rs.getString("resolver") == null) ? null : UserDAO.getByUsername(rs.getString("resolver")),
                        rs.getDouble("amount"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getString("justification"),
                        rs.getString("title")
                );
                return r;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Reimbursement update(Reimbursement reimbursement) {
        String sql = "update request set author = ?, title = ? where id = ?";
        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, reimbursement.getAuthor().getUsername());
            ps.setString(2, reimbursement.getTitle());
            ps.setInt(3, reimbursement.getId());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursement;
    }


    public static void delete(Integer id) {
        String sql = "delete from request where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static List<Reimbursement> getByUser(String author) {
        List<Reimbursement> reimbursements = new ArrayList<>();
        String sql = "select * from reimbursement_requests where author = ?";
        try(Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, author);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reimbursement r = new Reimbursement(
                        rs.getInt("id"),
                        rs.getString("status"),
                        (rs.getString("author") == null) ? null : UserDAO.getByUsername(rs.getString("author")),
                        (rs.getString("resolver") == null) ? null : UserDAO.getByUsername(rs.getString("resolver")),
                        rs.getDouble("amount"),
                        rs.getString("date"),
                        rs.getString("location"),
                        rs.getString("justification"),
                        rs.getString("title")
                );
                reimbursements.add(r);
            }
            return reimbursements;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


}
