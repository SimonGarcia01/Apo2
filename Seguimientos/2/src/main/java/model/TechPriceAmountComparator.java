package model;

import java.util.Comparator;

public class TechPriceAmountComparator implements Comparator<TechWare> {

    @Override
    public int compare(TechWare t1, TechWare t2){
        int comparison;

        if(t1.getPrice()==t2.getPrice()){
            comparison = t1.getAmount() - t2.getAmount();
        } else {
            comparison = (int) (t1.getPrice() - t2.getPrice());
        }

        return comparison;
    }

}
