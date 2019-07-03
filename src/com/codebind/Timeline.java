package com.codebind;

import server.ReTweet;
import server.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timeline {
    private JPanel panel1;
    private JPanel panel2;
    private JLabel image;
    private JLabel name;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel tweet1;
    private JLabel tweet2;
    private JLabel tweet3;
    private JLabel tweet4;
    private JButton name1;
    private JButton name2;
    private JButton name3;
    private JButton name4;
    private JLabel reT1;
    private JLabel reT2;
    private JLabel reT3;
    private JLabel reT4;
    private JButton likeButton3;
    private JButton reTweetButton3;
    private JButton likeButton;
    private JButton reTweetButton;
    private JButton likeButton1;
    private JButton reTweetButton1;
    private JButton likeButton2;
    private JButton reTweetButton2;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel likesnum;
    private JLabel likesnum1;
    private JLabel likesnum2;
    private JLabel likesnum3;
    private JLabel retnum;
    private JLabel retnum1;
    private JLabel retnum2;
    private JLabel retnum3;
    private JLabel reTweetedfrom;
    private JLabel reTweetedfrom1;
    private JLabel reTweetedfrom2;
    private JLabel reTweetedfrom3;
    private JTextField writeSomthingTextField;
    private JButton tweetButton;
    private JButton logOutButton;
    private JButton titleName;
    private JButton searchButton;
    public User user;
    public int i;

    Timeline(User user, int i) {
        this.i = i;
        this.user = user;
        $$$setupUI$$$();

        name1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  JOptionPane.showMessageDialog(null, i);
                Profile start = new Profile(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 1)).user, 0, user);
                // JOptionPane.showMessageDialog(null, "JJ");
                start.Start();
            }
        });
        name2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Profile start = new Profile(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 2)).user, 0, user);
                start.Start();
            }
        });
        name3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Profile start = new Profile(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 3)).user, 0, user);
                start.Start();
            }
        });
        name4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Profile start = new Profile(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 4)).user, 0, user);
                start.Start();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Timeline start = new Timeline(user, i + 1);
                start.Start();

            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Timeline start = new Timeline(user, i - 1);
                start.Start();
            }
        });


        likeButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                user.like(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 4)));
                likesnum3.setText(String.valueOf(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 4)).likes.size()));
                if (likeButton3.getText().equals("Like")) {
                    likeButton3.setText("unLike");
                    likeButton3.setBackground(new Color(255, 50, 100));
                } else {
                    likeButton3.setText("Like");
                    likeButton3.setBackground(new Color(242, 240, 255));
                }
                Timeline start = new Timeline(user, i);
                start.Start();
            }
        });
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                user.like(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 1)));
                likesnum.setText(String.valueOf(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 1)).likes.size()));
                if (likeButton.getText().equals("Like")) {
                    likeButton.setText("unLike");
                    likeButton.setBackground(new Color(255, 50, 100));
                } else {
                    likeButton.setText("Like");
                    likeButton.setBackground(new Color(242, 240, 255));
                }
                Timeline start = new Timeline(user, i);
                start.Start();
            }
        });
        likeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                user.like(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 2)));
                likesnum1.setText(String.valueOf(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 2)).likes.size()));
                if (likeButton1.getText().equals("Like")) {
                    likeButton1.setText("unLike");
                    likeButton1.setBackground(new Color(255, 50, 100));
                } else {
                    likeButton1.setText("Like");
                    likeButton1.setBackground(new Color(242, 240, 255));
                }
                Timeline start = new Timeline(user, i);
                start.Start();

            }
        });
        likeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                user.like(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 3)));
                likesnum2.setText(String.valueOf(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 3)).likes.size()));
                if (likeButton2.getText().equals("Like")) {
                    likeButton2.setText("unLike");
                    likeButton2.setBackground(new Color(255, 50, 100));
                } else {
                    likeButton2.setText("Like");
                    likeButton2.setBackground(new Color(242, 240, 255));
                }
                Timeline start = new Timeline(user, i);
                start.Start();
            }
        });
        reTweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // System.out.println(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 1)).text);
                user.retweet(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 1)));
                Timeline start = new Timeline(user, i);
                start.Start();
            }
        });
        reTweetButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                user.retweet(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 2)));
                Timeline start = new Timeline(user, i);
                start.Start();
            }
        });
        reTweetButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                user.retweet(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 3)));
                Timeline start = new Timeline(user, i);
                start.Start();
            }
        });
        reTweetButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                user.retweet(Twitter.tweets.get(user.timeline.get(user.timeline.size() - i - 4)));
                Timeline start = new Timeline(user, i);
                start.Start();
            }
        });
        tweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (writeSomthingTextField.getText().length() <= 140 && writeSomthingTextField.getText().length() > 1) {
                    user.tweet(writeSomthingTextField.getText());

                    Timeline start = new Timeline(user, i);
                    start.Start();
                } else if (writeSomthingTextField.getText().length() == 0) {
                               JOptionPane.showMessageDialog(null, "please write somthing!");
                } else {
                        JOptionPane.showMessageDialog(null, "your tweet is more than 140 char");
                }
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StartPage start = new StartPage();
                start.Start();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SearchPage start = new SearchPage(user);
                start.Start();
            }
        });
        titleName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Profile start = new Profile(user, 0, user);
                start.Start();
            }
        });
    }

    public void Start() {
        StartPage.GetFrame().setTitle("TimelLinePage");
        StartPage.GetFrame().setContentPane(panel1);
        StartPage.GetFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartPage.GetFrame().pack();
        StartPage.GetFrame().setVisible(true);
        StartPage.GetFrame().setSize(400, 500);
        if (i == 0) {
            previousButton.setVisible(false);
        }
        if (i + 4 >= user.timeline.size()) {
            nextButton.setVisible(false);
        }
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setAutoscrolls(false);
        panel1.setBackground(new Color(-3806977));
        panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-855809));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        image.setText("");
        panel2.add(image, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logOutButton = new JButton();
        logOutButton.setBackground(new Color(-16743746));
        logOutButton.setForeground(new Color(-855809));
        logOutButton.setText("Log Out");
        panel2.add(logOutButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        titleName.setBackground(new Color(-855809));
        titleName.setBorderPainted(false);
        titleName.setForeground(new Color(-16743746));
        panel2.add(titleName, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchButton = new JButton();
        searchButton.setBackground(new Color(-16743746));
        searchButton.setForeground(new Color(-1));
        searchButton.setText("Search");
        panel2.add(searchButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel3.setBackground(new Color(-855809));
        panel1.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        name1.setBackground(new Color(-855809));
        name1.setBorderPainted(false);
        name1.setForeground(new Color(-16743746));
        name1.setHorizontalTextPosition(2);
        panel3.add(name1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tweet1.setBackground(new Color(-6104065));
        panel3.add(tweet1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(75, 0), null, 0, false));
        reTweetButton.setBackground(new Color(-855809));
        reTweetButton.setForeground(new Color(-16091461));
        reTweetButton.setLabel("RT");
        reTweetButton.setText("RT");
        panel3.add(reTweetButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        likeButton.setBorderPainted(true);
        likeButton.setForeground(new Color(-10052933));
        panel3.add(likeButton, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel3.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        panel3.add(retnum, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel3.add(likesnum, new com.intellij.uiDesigner.core.GridConstraints(1, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("     ");
        panel3.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel3.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        panel3.add(reT1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel3.add(reTweetedfrom2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel4.setBackground(new Color(-855809));
        panel1.add(panel4, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        reTweetButton1.setBackground(new Color(-855809));
        reTweetButton1.setForeground(new Color(-16091461));
        reTweetButton1.setLabel("RT");
        reTweetButton1.setText("RT");
        panel4.add(reTweetButton1, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        likeButton1.setBorderPainted(true);
        likeButton1.setForeground(new Color(-10052933));
        panel4.add(likeButton1, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel4.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        tweet2.setBackground(new Color(-6104065));
        panel4.add(tweet2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(75, 0), null, 0, false));
        name2.setBackground(new Color(-855809));
        name2.setBorderPainted(false);
        name2.setForeground(new Color(-16743746));
        name2.setHorizontalTextPosition(2);
        panel4.add(name2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel4.add(retnum1, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel4.add(likesnum1, new com.intellij.uiDesigner.core.GridConstraints(1, 5, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel4.add(reTweetedfrom3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("    ");
        panel4.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 6, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panel4.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        panel4.add(reT2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel5.setBackground(new Color(-855809));
        panel1.add(panel5, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        likeButton2.setBorderPainted(true);
        likeButton2.setForeground(new Color(-10052933));
        panel5.add(likeButton2, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel5.add(retnum2, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel5.add(likesnum2, new com.intellij.uiDesigner.core.GridConstraints(1, 5, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel5.add(reTweetedfrom1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        name3.setBackground(new Color(-855809));
        name3.setBorderPainted(false);
        name3.setForeground(new Color(-16743746));
        name3.setHorizontalTextPosition(2);
        panel5.add(name3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        panel5.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        reTweetButton2.setBackground(new Color(-855809));
        reTweetButton2.setForeground(new Color(-16091461));
        reTweetButton2.setLabel("RT");
        reTweetButton2.setText("RT");
        panel5.add(reTweetButton2, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tweet3.setBackground(new Color(-6104065));
        panel5.add(tweet3, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(75, 0), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("    ");
        panel5.add(label7, new com.intellij.uiDesigner.core.GridConstraints(1, 6, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        panel5.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        panel5.add(reT3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel6.setBackground(new Color(-855809));
        panel1.add(panel6, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        name4.setBackground(new Color(-855809));
        name4.setBorderPainted(false);
        name4.setForeground(new Color(-16743746));
        name4.setHorizontalTextPosition(2);
        panel6.add(name4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reTweetButton3.setBackground(new Color(-855809));
        reTweetButton3.setForeground(new Color(-16091461));
        reTweetButton3.setLabel("RT");
        reTweetButton3.setText("RT");
        panel6.add(reTweetButton3, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        likeButton3.setBorderPainted(true);
        likeButton3.setForeground(new Color(-10052933));
        panel6.add(likeButton3, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel6.add(retnum3, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel6.add(likesnum3, new com.intellij.uiDesigner.core.GridConstraints(1, 5, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        panel6.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        tweet4.setBackground(new Color(-6104065));
        panel6.add(tweet4, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(75, 0), null, 0, false));
        panel6.add(reTweetedfrom, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel6.add(reT4, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("    ");
        panel6.add(label8, new com.intellij.uiDesigner.core.GridConstraints(1, 6, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        panel6.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        nextButton = new JButton();
        Font nextButtonFont = this.$$$getFont$$$("Fira Code Retina", -1, -1, nextButton.getFont());
        if (nextButtonFont != null) nextButton.setFont(nextButtonFont);
        nextButton.setHorizontalTextPosition(0);
        nextButton.setText("v");
        panel1.add(nextButton, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        previousButton = new JButton();
        Font previousButtonFont = this.$$$getFont$$$("Fira Code Retina", Font.BOLD, -1, previousButton.getFont());
        if (previousButtonFont != null) previousButton.setFont(previousButtonFont);
        previousButton.setText("^");
        panel1.add(previousButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 4, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel7.setBackground(new Color(-855809));
        panel1.add(panel7, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tweetButton = new JButton();
        tweetButton.setBackground(new Color(-16743746));
        tweetButton.setFocusPainted(false);
        tweetButton.setForeground(new Color(-855809));
        tweetButton.setText("Tweet");
        panel7.add(tweetButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("   ");
        panel7.add(label9, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("    ");
        panel7.add(label10, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        writeSomthingTextField = new JTextField();
        writeSomthingTextField.setBackground(new Color(-3806977));
        writeSomthingTextField.setCaretColor(new Color(-16743746));
        writeSomthingTextField.setText("write somthing");
        panel7.add(writeSomthingTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        image = new JLabel(new ImageIcon("twitter2.png"));
        titleName = new JButton(user.name);
        name1 = new JButton("");
        name2 = new JButton("");
        name3 = new JButton("");
        name4 = new JButton("");
        tweet1 = new JLabel("");
        tweet2 = new JLabel("");
        tweet3 = new JLabel("");
        tweet4 = new JLabel("");
        likeButton = new JButton("");
        likeButton1 = new JButton("");
        likeButton2 = new JButton("");
        likeButton3 = new JButton("");
        reTweetButton = new JButton("");
        reTweetButton1 = new JButton("");
        reTweetButton2 = new JButton("");
        reTweetButton3 = new JButton("");
        likesnum = new JLabel("");
        likesnum1 = new JLabel("");
        likesnum2 = new JLabel("");
        likesnum3 = new JLabel("");
        retnum = new JLabel("");
        retnum1 = new JLabel("");
        retnum2 = new JLabel("");
        retnum3 = new JLabel("");
        reT1 = new JLabel("");
        reT2 = new JLabel("");
        reT3 = new JLabel("");
        reT4 = new JLabel("");
        reTweetedfrom = new JLabel("");
        reTweetedfrom1 = new JLabel("");
        reTweetedfrom2 = new JLabel("");
        reTweetedfrom3 = new JLabel("");
        int j = i;
        if (j + 1 <= user.timeline.size()) {
            tweetBox(j, name1, tweet1, likesnum, retnum, reTweetButton, likeButton, reTweetedfrom2, reT1);
            j++;
        } else {
            likeButton.setVisible(false);
            reTweetButton.setVisible(false);
        }
        if (j + 1 <= user.timeline.size()) {
            tweetBox(j, name2, tweet2, likesnum1, retnum1, reTweetButton1, likeButton1, reTweetedfrom3, reT2);
            j++;
        } else {
            likeButton1.setVisible(false);
            reTweetButton1.setVisible(false);
        }
        if (j + 1 <= user.timeline.size()) {
            tweetBox(j, name3, tweet3, likesnum2, retnum2, reTweetButton2, likeButton2, reTweetedfrom1, reT3);
            j++;
        } else {
            likeButton2.setVisible(false);
            reTweetButton2.setVisible(false);
        }
        if (j + 1 <= user.timeline.size()) {
            tweetBox(j, name4, tweet4, likesnum3, retnum3, reTweetButton3, likeButton3, reTweetedfrom, reT4);
            j++;
        } else {
            likeButton3.setVisible(false);
            reTweetButton3.setVisible(false);
        }

    }

    public void tweetBox(int j, JButton name, JLabel tweet, JLabel likesnum, JLabel retnum, JButton reTweetButton, JButton likeButton, JLabel reTweetedfrom, JLabel reT) {
        name.setText(convertToMultiline(Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)).user.name));
        tweet.setText(Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)).text);
        likesnum.setText(String.valueOf(Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)).likesnum));
        retnum.setText(String.valueOf(Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)).retweetsnum));

        if (Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)).user.equals(user)) {
            reTweetButton.setVisible(false);
            retnum.setText("RT: " + String.valueOf(Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)).retweetsnum));
        }
        boolean flag = false;
        for (int i = 0; i < Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)).likes.size(); i++) {
            if (Twitter.users.get(Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)).likes.get(i)).equals(user)) {
                flag = true;
            }
        }

        if (!flag) {
            likeButton.setText("Like");
            likeButton.setBackground(new Color(242, 240, 255));

        } else {
            likeButton.setText("unLike");
            likeButton.setBackground(new Color(255, 50, 100));
        }

        if (Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1)) instanceof ReTweet) {
            reTweetedfrom.setText("RT from");
            reT.setText(Twitter.users.get(((ReTweet) Twitter.tweets.get(user.timeline.get(user.timeline.size() - j - 1))).retweeter).name);
        }

    }

    public static String convertToMultiline(String text) {
        return "<html>" + text.replaceAll("\n", "<br>");
    }

}

