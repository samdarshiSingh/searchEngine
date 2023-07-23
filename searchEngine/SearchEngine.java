import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine extends JFrame implements ActionListener {

    private JTextField searchField;
    private JTextArea searchResultsArea;
    private List<String> data;

    public SearchEngine() {
        super("Search Engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        data = new ArrayList<>();
        data.add("LinkedIn");
        data.add("Google");
        data.add("Twitter");
        data.add("gmail");
        data.add("gitHub");

        searchField = new JTextField();
        searchField.addActionListener(this);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        searchResultsArea = new JTextArea();
        searchResultsArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(searchResultsArea);

        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String query = searchField.getText();
        if (!query.isEmpty()) {
            search(query);
        }
    }

    private void search(String query) {
        StringBuilder resultText = new StringBuilder();
        for (String item : data) {
            if (item.toLowerCase().contains(query.toLowerCase())) {
                resultText.append(item).append("\n");
            }
        }
        if (resultText.length() == 0) {
            resultText.append("No results found.");
        }
        searchResultsArea.setText(resultText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SearchEngine());
    }
}
