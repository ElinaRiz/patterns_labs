import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class View extends JFrame {
    private Model model;
    private JTable table;
    private DefaultTableModel tableModel;
    private ChartPanel chartPanel;
    private JButton addButton, deleteButton, editButton;

    public View(Model m) {
        model = m;
        setTitle("График функции");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel functionLabel = new JLabel("Нелинейная функция: y = x^2");
        add(functionLabel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"x", "y"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setPreferredSize(new Dimension(200, 0));

        JPanel tableAndButtonPanel = new JPanel(new BorderLayout());
        tableAndButtonPanel.add(tableScroll, BorderLayout.CENTER);

        addButton = new JButton("Добавить");
        deleteButton = new JButton("Удалить");
        editButton = new JButton("Изменить");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        tableAndButtonPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(tableAndButtonPanel, BorderLayout.WEST);

        XYSeries series = new XYSeries("y = x^2");
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("y = x^2", "x", "y", dataset, PlotOrientation.VERTICAL, false, false, false);
        chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
    }

    public int getSelectedRowIndex() {
        return table.getSelectedRow();
    }

    public void updateTableAndChart() {
        List<DataPoint> data = model.getData();
        tableModel.setRowCount(0);
        for (DataPoint point : data) {
            tableModel.addRow(new Object[]{point.getX(), point.getY()});
        }

        XYSeries series = new XYSeries("y = x^2");
        for (DataPoint point : model.getData()) {
            series.add(point.getX(), point.getY());
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("y = x^2", "x", "y", dataset, PlotOrientation.VERTICAL, false, false, false);
        chartPanel.setChart(chart);
    }

    public String inputX(String message, String title) {
        return JOptionPane.showInputDialog(this, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    public void showInformationMessage(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getEditButton() {
        return editButton;
    }
}
