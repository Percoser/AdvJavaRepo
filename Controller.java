package sample;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                ObservableValue<?extends Worker> ov, Worker old_val, Worker new_val)-> //Some Syntax you just have to get used to
                {
                    Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();
                    //try {
                        fNameText.setText(((Employee) selectedItem).fname); //type-casting selectedItem to type Employee
                        lNameText.setText(((Employee) selectedItem).lname);
                        isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);
                        miscText.setText(((Employee) selectedItem).lname);
                    //}catch //try to do this at home
                }
                );

        ObservableList<Employee> items = employeeListView.getItems();
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.fname="Robert";
        emp1.lname="Rogers";
        emp2.fname = "Julia";
        emp2.lname = "Smith";


        items.add(emp1);
        items.add(emp2);

        for(int i=0; i<10; i++){
            Employee employee = new Employee();
            employee.fname = "Generic ";
            employee.lname = "Employee " + i;
            employee.hire();
            items.add(employee);
        }
        Staff staff1 = new Staff();
        staff1.fname = "StaffPerson";
        staff1.lname = "GoodWorker";

        Faculty fact1 = new Faculty();
        fact1.fname= "FacultyPerson";
        fact1.lname="TerribleWorker";

        items.add(staff1);
        items.add(fact1);

    }
}
