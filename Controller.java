package sample;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView<Employee> employeeListView;
    @FXML
    private TextField fNameText;
    @FXML
    private TextField lNameText;
    @FXML
    private CheckBox isActiveCheckBox;
    @FXML
    private TextField miscText;
    @FXML
    private Button deleteButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button addButton;
    @FXML
    private Button fireButton;
    @FXML
    private Button hireButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<Employee> items = employeeListView.getItems();

        employeeListView.getSelectionModel().selectedItemProperty().addListener
                ((
                ObservableValue<?extends Worker> ov, Worker old_val, Worker new_val)-> //Some Syntax you just have to get used to
                {
                    Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();
                    //try {
                        fNameText.setText(((Employee) selectedItem).fname); //type-casting selectedItem to type Employee
                        lNameText.setText(((Employee) selectedItem).lname);
                        isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);
//                        miscText.setText(((Employee) selectedItem).empid.toString());
                    //}catch //try to do this at home

                    deleteButton.setOnAction(new EventHandler<ActionEvent>()
                    {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int selectedID = employeeListView.getSelectionModel().getSelectedIndex();
                            if(selectedID!= -1){
                                items.remove(selectedItem);
                                employeeListView.getSelectionModel().selectFirst();
                            }
                        }
                    });

                    isActiveCheckBox.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (((Employee) selectedItem).isActive == false){
                                selectedItem.hire();
                                isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);
                            }else if(((Employee) selectedItem).isActive == true){
                                selectedItem.fire();
                                isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);
                            }
                        }
                    });
                    fireButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            selectedItem.fire();
                            isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);
                        }
                    });
                    hireButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            selectedItem.hire();
                            isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);
                        }
                    });
                });

                    clearButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            fNameText.setText("");
                            lNameText.setText("");
                            isActiveCheckBox.setSelected(false);
                            miscText.setText("");
                        }
                    });
                    addButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Employee emp0 = new Employee();

                            emp0.fname = fNameText.getText();
                            emp0.lname = lNameText.getText();
                            emp0.isActive = isActiveCheckBox.isSelected();
//                            emp0.empid = UUID.fromString(miscText.getText());

                            items.add(emp0);

//                            fNameText.setText("");
//                            lNameText.setText("");
//                            if(isActiveCheckBox.isSelected()) {
//                                isActiveCheckBox.fire();
//                            }
//                            miscText.setText("");
                        }
                    });





//        Employee emp1 = new Employee();
//        Employee emp2 = new Employee();
//        emp1.fname="Robert";
//        emp1.lname="Rogers";
//        emp2.fname = "Julia";
//        emp2.lname = "Smith";


//        items.add(emp1);
//        items.add(emp2);

//        for(int i=0; i<10; i++){
//            Employee employee = new Employee();
//            employee.fname = "Generic ";
//            employee.lname = "Employee " + i;
//            employee.hire();
//            items.add(employee);
//        }
//        Staff staff1 = new Staff();
//        staff1.fname = "StaffPerson";
//        staff1.lname = "GoodWorker";
//
//        Faculty fact1 = new Faculty();
//        fact1.fname= "FacultyPerson";
//        fact1.lname="TerribleWorker";
//
//        items.add(staff1);
//        items.add(fact1);

    }
}
