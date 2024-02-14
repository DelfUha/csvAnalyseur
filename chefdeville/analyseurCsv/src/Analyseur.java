import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;



public class Analyseur {
    private List<List<String>> resultat = new ArrayList<>();
    private String field;

    public Analyseur() throws Exception {
        getLinesFromFile();
        mettreSimplecotes();
        afficherResultat();
    }

    public void  getLinesFromFile() throws Exception {

        try {
             // Création d'un fileReader pour lire le fichier
            FileReader fileReader = new FileReader("csv/guillements.csv");

            // Création d'un bufferedReader qui utilise le fileReader
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while((line = reader.readLine()) != null)
             {
                 List<String> tableau = new ArrayList<>();
                 tableau.add(line);
                 resultat.add(tableau);
             }
            fileReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void mettreSimplecotes(){
        String cote = "'";
        String test = "";
        for(int i = 0; i<resultat.size(); i++){
            List<String> liste      = resultat.get(i);
            List<String> listeCote  = new ArrayList<>();
            for(String listePart : liste){
                String[] splitTab   = listePart.split(",");
                for(int z=0; z < splitTab.length; z++){
                    String contenu      = splitTab[z];
                    String replaceCote  = cote+contenu+cote;
                    if(replaceCote.contains("\"")){
                        String debut = replaceCote.substring(0,2);
                        String fin = replaceCote.substring(replaceCote.length()-2);
                        if(debut == "\'\""){
                           // System.out.println(" passe part 1");
                        }


                       // System.out.println("passe double cote");

                        test = replaceCote.replace("\"\"", "\"");
                       // System.out.println("test =>"+test);
                    }
                    listeCote.add(replaceCote);
                }
                resultat.set(i, listeCote);
            }
        }
    }


    public void afficherResultat(){
        System.out.println(resultat);
    }




}
