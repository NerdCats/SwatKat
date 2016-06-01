package co.gobd.tracker.utility.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import co.gobd.tracker.model.job.order.OrderCart;
import co.gobd.tracker.model.job.order.PackageList;

/**
 * Created by fahad on 5/16/16.
 */
public class OrderCartDeserializer implements JsonDeserializer<OrderCart> {

    private OrderCart orderCart;

    @Override
    public OrderCart deserialize(JsonElement json, Type typeOfT,
                                 JsonDeserializationContext context)
            throws JsonParseException {
        List<PackageList> packageLists = new ArrayList<>();

        final JsonObject jsonObject = json.getAsJsonObject();
        final JsonArray packageListArray = jsonObject.getAsJsonArray("PackageList");

        for(int i = 0; i < packageListArray.size(); i++){

            final JsonObject packageList = packageListArray.get(i).getAsJsonObject();
            String Item = packageList.get("Item").getAsString();
            Integer Quantity = packageList.get("Quantity").getAsInt();
            Double Price = packageList.get("Price").getAsDouble();
            Double VAT = packageList.get("VAT").getAsDouble();
            Double Total = packageList.get("Total").getAsDouble();
            Double VATAmount = packageList.get("VATAmount").getAsDouble();
            Double TotalPlusVAT = packageList.get("TotalPlusVAT").getAsDouble();
            Double Weight = packageList.get("Weight").getAsDouble();

            PackageList obj = new PackageList(Item, Quantity, Price, VAT,
                    Total, VATAmount, TotalPlusVAT, Weight);

            packageLists.add(obj);
        }

        Double TotalVatAmount = jsonObject.get("TotalVATAmount").getAsDouble();
        Double SubTotal = jsonObject.get("SubTotal").getAsDouble();
        Double ServiceCharge = jsonObject.get("ServiceCharge").getAsDouble();
        Double TotalWeight = jsonObject.get("TotalWeight").getAsDouble();
        Double TotalToPay = jsonObject.get("TotalToPay").getAsDouble();

        orderCart = new OrderCart(packageLists, TotalVatAmount, SubTotal,
                ServiceCharge, TotalWeight, TotalToPay);

        return orderCart;

    }
}
