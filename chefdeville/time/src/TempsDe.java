import java.util.ArrayList;
import java.util.List;

public class TempsDe {
    private int reste;
    private List<String> stringShapeOfTime  = new ArrayList<>();
    private List<Integer> intShapeOfTime    = new ArrayList<>();
    private StringBuilder resultat = new StringBuilder();

    public TempsDe(int reste) {
        this.reste = reste;
        initShapeOfTime();
        initIntShapeOfTime();
        calculateTemps(stringShapeOfTime, intShapeOfTime);
        getSecondes();
        System.out.println(resultat);
    }

    private void initShapeOfTime(){
        this.stringShapeOfTime.add("annee");
        this.stringShapeOfTime.add("jour");
        this.stringShapeOfTime.add("heure");
        this.stringShapeOfTime.add("minute");

    }

    private void initIntShapeOfTime(){
        this.intShapeOfTime.add(31536000);
        this.intShapeOfTime.add(86400);
        this.intShapeOfTime.add(3600);
        this.intShapeOfTime.add(60);

    }

    private void calculateTemps(List<String>stringShapeOfTime, List<Integer> intShapeOfTime) {
       for(int i = 0; i<stringShapeOfTime.size(); i++){
           int calculateValue = reste/ intShapeOfTime.get(i);
           reste = reste % intShapeOfTime.get(i);
           if(calculateValue > 1 ) {
               resultat.append(calculateValue);
               resultat.append(" ");
               resultat.append(stringShapeOfTime.get(i));
               resultat.append("s, ");
           }
           if(calculateValue == 1 ) {
               resultat.append(calculateValue);
               resultat.append(" ");
               resultat.append(stringShapeOfTime.get(i));
               resultat.append(", ");
           }

       }
       resultat.deleteCharAt(resultat.length()-2);
    }
    private void getSecondes(){
        if(this.reste > 0){
            resultat.append("et ");
            resultat.append(reste);
            resultat.append(" seconde");
            if(reste > 1){resultat.append("s");}
        }
    }
}
