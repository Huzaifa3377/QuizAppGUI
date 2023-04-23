import javax.swing.*;

public class QuizAppGUI extends JFrame {
    private JPanel panel;
    private JLabel questionLabel, scoreLabel;
    private JTextField answerField;
    private JButton submitButton;
    private String[][] quiz = {
            {"How many boys hostel are there in LPU?", "8"},
            {"Who is the founder of LPU?", "Baldev Raj Mittal"},
            {"Where is shanti devi hall?", "35 block"}
    };
    private int score = 0;

    public QuizAppGUI() {
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        questionLabel = new JLabel(quiz[0][0]);
        panel.add(questionLabel);

        answerField = new JTextField(20);
        panel.add(answerField);


        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String answer = answerField.getText().toLowerCase();
            if (answer.equals(quiz[score][1].toLowerCase())) {
                JOptionPane.showMessageDialog(null, "Correct!");
                score++;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + quiz[score][1]);
            }
            if (score < quiz.length) {
                questionLabel.setText(quiz[score][0]);
                answerField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Quiz complete! Your score is " + score + " out of " + quiz.length);
                System.exit(0);
            }
        });
        panel.add(submitButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
		setSize(420,420); 
    }

    public static void main(String[] args) {
        QuizAppGUI quizAppGUI = new QuizAppGUI();
    }
}
