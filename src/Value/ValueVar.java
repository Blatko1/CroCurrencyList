package Value;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ValueVar {

    private final StringProperty country = new SimpleStringProperty();
    private final StringProperty currency = new SimpleStringProperty();
    private final StringProperty value = new SimpleStringProperty();

    public ValueVar(String country, String currency, String value){
        this.country.setValue(country);
        this.currency.setValue(currency);
        this.value.setValue(value);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public String getCurrency() {
        return currency.get();
    }

    public StringProperty currencyProperty() {
        return currency;
    }

    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }
}
