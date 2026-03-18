import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = view.inputX("Введите значение x:", "Ввод");
                try {
                    model.addX(Double.parseDouble(input));
                    view.updateTableAndChart();
                } catch (NumberFormatException ex) {
                    view.showInformationMessage("Некорректный ввод x: " + input, "Ошибка ввода");
                } catch (DuplicateXException ex) {
                    view.showInformationMessage(ex.getMessage(), "Ошибка ввода");
                } catch (NullPointerException ignored) {}
            }
        });

        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getSelectedRowIndex();
                if (index >= 0) {
                    model.removeX(index);
                    view.updateTableAndChart();
                } else {
                    view.showInformationMessage("Выберите строку для удаления.", "Ошибка удаления");
                }
            }
        });

        view.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getSelectedRowIndex();
                if (index >= 0) {
                    String input = view.inputX("Введите новое значение x:", "Изменение");
                    try {
                        model.updateX(index, Double.parseDouble(input));
                        view.updateTableAndChart();
                    } catch (NumberFormatException ex) {
                        view.showInformationMessage("Некорректный ввод x: " + input, "Ошибка изменения");
                    } catch (DuplicateXException ex) {
                        view.showInformationMessage(ex.getMessage(), "Ошибка изменения");
                    } catch (NullPointerException ignored) {}
                } else {
                    view.showInformationMessage("Выберите строку для изменения.", "Ошибка изменения");
                }
            }
        });
    }

    public void start() {
        view.setVisible(true);
    }
}
