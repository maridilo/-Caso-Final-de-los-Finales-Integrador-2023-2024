package Ejercicio5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static JFrame frame;
    private static UserAccount currentUser;
    private static List<UserAccount> users = new ArrayList<>();

    public static void main(String[] args) {
        loadUsersFromFile("users.txt");

        frame = new JFrame("Twitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String alias = JOptionPane.showInputDialog(frame, "Introduce el alias del usuario:");
                currentUser = findUser(alias);
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(frame, "Usuario no encontrado");
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuario cargado: " + currentUser);
                }
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String alias = JOptionPane.showInputDialog(frame, "Enter the new user's alias:");
                String email = JOptionPane.showInputDialog(frame, "Enter the new user's email:");
                registerUser(alias, email);
            }
        });

        JButton tweetButton = new JButton("Tweet");
        tweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentUser == null) {
                    JOptionPane.showMessageDialog(frame, "Debes cargar un usuario primero");
                    return;
                }
                String message = JOptionPane.showInputDialog(frame, "Introduce el mensaje:");
                Tweet tweet = new Tweet(message, currentUser, LocalDateTime.now());
                currentUser.getTweets().add(tweet);
                for (UserAccount follower : currentUser.getFollowers()) {
                    follower.getTimeline().add(tweet);
                }
            }
        });

        JButton sortButton = new JButton("Ordenar usuarios por email");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(users, Comparator.comparing(UserAccount::getEmail));
                JOptionPane.showMessageDialog(frame, "Usuarios ordenados por email: " + users);
            }
        });

        JButton showButton = new JButton("Mostrar usuarios");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Usuarios: " + users);
            }
        });



        JPanel panel = new JPanel();
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(tweetButton);
        panel.add(sortButton);
        panel.add(showButton);
        frame.add(panel);

        frame.setVisible(true);


    }

    private static void loadUsersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String alias = parts[0];
                String email = parts[1];
                users.add(new UserAccount(alias, email));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static UserAccount findUser(String alias) {
        for (UserAccount user : users) {
            if (user.getAlias().equals(alias)) {
                return user;
            }
        }
        return null;
    }

    private static void registerUser(String alias, String email) {
        users.add(new UserAccount(alias, email));
        writeUserToFile(alias, email);
    }

    private static void writeUserToFile(String alias, String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(alias + "," + email);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
