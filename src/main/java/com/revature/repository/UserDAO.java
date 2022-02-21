package com.revature.repository;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO{

        static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();





        public static User getById(Integer id) {
                String sql = "select * from users where id = ?";
                try (Connection conn = cu.getConnection()) {
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setInt(1, id);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                                User u = new User(
                                        rs.getInt("id"),
                                        rs.getString("first_name"),
                                        rs.getString("last_name"),
                                        rs.getString("username"),
                                        rs.getString("email"),
                                        rs.getString("password"),
                                        rs.getString("position"));

                                return u;
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return null;
        }

        public static User getByUsername(String username) {
                String sql = "select * from users where username = ?";
                try (Connection conn = cu.getConnection()) {
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, username);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                                User u = new User(
                                        rs.getInt("id"),
                                        rs.getString("first_name"),
                                        rs.getString("last_name"),
                                        rs.getString("username"),
                                        rs.getString("email"),
                                        rs.getString("password"),
                                        rs.getString("position")
                                        );
                                return u;
                        }
                } catch (SQLException e) {
                        e.printStackTrace();

                }
                return null;
        }

                public static List<User> getAllUsers() {
                        List<User> users = new ArrayList<>();
                        String sql = "select * from users";
                        try (Connection conn = cu.getConnection()) {
                                PreparedStatement ps = conn.prepareStatement(sql);
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                                        User u = new User(
                                                rs.getInt("id"),
                                                rs.getString("first_name"),
                                                rs.getString("last_name"),
                                                rs.getString("username"),
                                                rs.getString("email"),
                                                rs.getString("password"),
                                                rs.getString("position")
                                        );
                                        users.add(u);
                                }
                                return users;
                        } catch (SQLException e) {
                                e.printStackTrace();
                        }
                        return null;
                }


                        public static void update(User users) {
                                String sql = "update users set first_name = ?, last_name = ? where id = ?";
                                try (Connection conn = cu.getConnection()) {

                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setString(1, users.getFirstName());
                                        ps.setString(2, users.getLastName());
                                        ps.setInt(3, users.getId());

                                        ps.executeUpdate();

                                }catch (SQLException e) {
                                        e.printStackTrace();
                                }
                        }


                        public static void delete(Integer id) {
                                String sql = "delete from users where id = ?";

                                try (Connection conn = cu.getConnection()) {
                                        PreparedStatement ps = conn.prepareStatement(sql);
                                        ps.setInt(1, id);
                                        ps.executeUpdate();
                                } catch (SQLException e) {
                                        e.printStackTrace();
                                }
                        }
                                public static User create(User user) {
                                        String sql = "insert into users (id,first_name,last_name,username,email,password,position) values (default, ?, ?, ?, ?, ?,?)";
                                        try (Connection conn = cu.getConnection()) {
                                                PreparedStatement ps = conn.prepareStatement(sql);
                                                ps.setString(1, user.getFirstName());
                                                ps.setString(2, user.getLastName());
                                                ps.setString(3, user.getUsername());
                                                ps.setString(4, user.getEmail());
                                                ps.setString(5, user.getPassword());
                                                ps.setString(6, user.getPosition());
                                                ps.executeUpdate();
                                                return user;

                                } catch (SQLException e) {
                                        e.printStackTrace();
                                }
                                return user;
                        }


        }



