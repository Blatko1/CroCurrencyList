package sample;

import URLReader.URLReader;
import Value.ValueVar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public TableView<ValueVar> table;
    public TableColumn<ValueVar, String> countryColumn;
    public TableColumn<ValueVar, String> currencyColumn;
    public TableColumn<ValueVar, String> valueColumn;

    public void initialize(URL url, ResourceBundle rb){
        URLReader urlReader = new URLReader();
        countryColumn.setCellValueFactory(new PropertyValueFactory<ValueVar, String>("country"));
        currencyColumn.setCellValueFactory(new PropertyValueFactory<ValueVar, String>("currency"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<ValueVar, String>("value"));
        countryColumn.setResizable(false);
        currencyColumn.setResizable(false);
        valueColumn.setResizable(false);
        table.setItems(updateValues());
    }

    public ObservableList<ValueVar> updateValues(){

        try {
            ObservableList<ValueVar> lista = FXCollections.observableArrayList();
            int lenght = URLReader.getMap().keySet().toArray().length;
            for(int i = 0;i < lenght; i++){
                String str = URLReader.getCurrencie(i);
                lista.add(new ValueVar(str.substring(0, str.length()-4), str.substring(str.length()-3), URLReader.getValues()[i]));
            }
            System.out.println("Updated!");
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initializer(ActionEvent actionEvent) {
        initialize(null, null);
    }
}
