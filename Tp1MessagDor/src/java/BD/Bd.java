/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Metier.MessageDor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 21708582
 */
public class Bd {
    private static final String URL="jdbc:mysql://etu-web2.ut-capitole.fr:3306/db_21708582";
    private static final String LOGIN="21708582";
    private static final String PASSWORD="Q00L84";
    private static Connection cx;
    /**
     * la conexion sur le seveur mysql 
     * @throws Exception 
     */
    public static void connexion()throws Exception{
        /**
         * je gère le probleme de conexion 
         */
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception ("probleme de connexion  1: "+e.getMessage());
        }
        /**
         * S'il ya des erreur sur l'URL, LOGIN ou PASSWORD  on gère les erreurs
         */
        try{
            Bd.cx = DriverManager.getConnection(URL,LOGIN,PASSWORD);   
        }catch(SQLException sqle)
         {
            throw new Exception("probleme de connexion 2: "+sqle.getMessage());
         }
    }
    /**
     * la methode lireMessage permet d'effectuer une requete sql select afin de recuperer la liste
     * le parametre  en entrée est vide 
     * en sortie on obtient une arralist des message
     * @return
     * @throws Exception 
     */
    public static ArrayList<MessageDor> lireMessage()throws Exception{
        
        if (Bd.cx==null) {
            Bd.connexion();           
        }
        /**
         * je fait un select pour pour recuperer tout les message de la Bd
         */
        PreparedStatement st  ;
        String sql = "select NumMsg,text,Pseudo from Message";
        try {
            st = Bd.cx.prepareStatement(sql);
        } catch (SQLException e) {
            throw new Exception(" probeme d'ouverture "
                    + " d'espace de requete :"+e.getMessage());
        }
        /**
         * je crée un arraylist dans la quelle je stock tout les n-uplet qui se trouve dans la Bd
         * je verifie au cours de l'execution s'il des erreur je les affiche travers le catch
         */
        
        ArrayList<MessageDor> list= new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new MessageDor(rs.getInt("NumMsg"),rs.getString("Pseudo"),rs.getString("text")));
            }
        } catch (SQLException e) {
             throw new Exception(" probeme d'ouverture 1 "
                    + " d'espace de requete :"+e.getMessage());
        }
        /**
         * je ferme la Bd
         */
        st.close();
        /**
         * je retourne ma liste
         */
        return list;
    }
    /**
     * La méthode de saisireMessage permet de saisir les sur la Bd
     * en entrée nous avons un message d'or et en sorti un entier pour verifier si le code est bon
     * @param msg
     * @return
     * @throws Exception 
     */
   public static int saisireMessage(MessageDor msg)throws Exception{
       
       /**
        * verifaction si la Bd est
        */
       int nb=0;
        if (Bd.cx==null) {
            Bd.connexion();           
        }
        /**
         * je prepare ma requet d'insertion avec les parametre de recuperer par le message d'or en entrée Message et Speudo
         */
        PreparedStatement st  ;
        String sql="INSERT into Message(Pseudo, text) values(\""+msg.getPseudo()+"\",\""+msg.getMessage()+"\")";
        
        try {
            st = Bd.cx.prepareStatement(sql);
            
           
             nb=st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new Exception(" probeme d'enregistrement 2 "
                    + " d'espace de requete :"+e.getMessage());
            
        }
        /**
         * la renvoi le code de retour de executeupdate()
         */
        
        return nb;
   }
   /**
    * la methode efface un message permet de suprime un message dans la bd
    * en entrée on peut avoir une liste de liste de message a supprimer en même temps 
    * en sorti on a rien c'est un void 
    * @param liste
    * @throws Exception 
    */
   public static void  effacerMessage(  ArrayList<String>  liste) throws Exception{
       
       if (Bd.cx==null){
           Bd.connexion();
          
       }
       /**
        * j'effectue delete sur la liste en parametre 
        *  la condition du numero de message  est parametrer
        */
        PreparedStatement st;
        String sql ="DELETE FROM Message WHERE NumMsg=?";
        try {
           st=Bd.cx.prepareStatement(sql);
       } catch (SQLException e) {
           throw new Exception ("Erreur, Probleme d'ouverture de l'espace de la requete lors de la suppresion");
       }
        try {
            /**
             * je parcour toute la liste a supprimer 
             */
            for (String listElemSup : liste) {
                st.setInt(1, Integer.valueOf(listElemSup));
                st.executeUpdate();
                
            }
       } catch (SQLException e) {
           throw new Exception("Error, Problème de suppression -"+e.getMessage());
       }
   }
   /**
    * cette methode en entrée possède un message d'or 
    * @param msgdor
    * @throws Exception 
    */
   public static void  modifierMsg(MessageDor msgdor)throws Exception{
       
        if (Bd.cx==null)
        {
           Bd.connexion();
        }   
        /**
         * la requete de mise a jour , on modifie le contenu de pseudo et message avec la condtion
         * where sur le numero de message 
         */
        PreparedStatement st;
        String sql ="UPDATE Message  SET Pseudo=\""+msgdor.getPseudo()+"\",text=\""+msgdor.getMessage()+"\" WHERE NumMsg=\""+msgdor.getId()+"\"";
        
        try {
           st=Bd.cx.prepareStatement(sql);
       }catch (SQLException e) {
           throw new Exception ("Erreur, Probleme d'ouverture de l'espace de la requete lors de la suppresion");
       }
       try {
           int codeRetourUpdate= st.executeUpdate();
       } catch (SQLException e) {
            throw new Exception ("Error, problemme de mise à jour"+e.getMessage());       
       }
   }
   /**
    * la fonction suivante permet de recuperer de recuperer un message d'or a partir de l'indentifiant passer en parametre
    * @param identifiant
    * @return
    * @throws Exception 
    */
   public static MessageDor getMessageDor(String identifiant) throws Exception{
       
       if (Bd.cx==null){
           Bd.connexion();         
       }
       PreparedStatement st;
       String sqlInt="SELECT NumMsg, Pseudo,text from Message";
       
       try {
           st=Bd.cx.prepareStatement(sqlInt);
       } catch (SQLException e) {
           throw new Exception("Erreur, Probleme d'ouverture d'espace de requête "+e.getMessage());
       }
       MessageDor listMsgModif = null ;
       try {
           ResultSet req= st.executeQuery();
           while(req.next()){
               /**
                * verifiation de l'element passer en parametre si c'est u identifiant 
                */
               if(req.getInt(1)== Integer.parseInt(identifiant)){
                   listMsgModif= new MessageDor(req.getInt(1),req.getString(2),req.getString(3));
                   
                   
               }
           }
       } catch (SQLException e) {
           throw new Exception (" Erreur de lecture des messade d'or"+e.getMessage());
       }
       /**
        * retourne le messagde d'or
        */
       return listMsgModif;
   }
   /**
    * un test du cote admin pour voir si toutes les foctions marche avant de leur utiliser dans les fichier jsp pour la vue  
    * @param args 
    */
    public static void main(String[] args) {
        
        
        try {
            Bd.connexion();
        } catch (Exception e) {
            System.out.println("BD.Bd.main() :"+e.getMessage());
        }
        try {
            
            for (MessageDor m : Bd.lireMessage()) {
                System.out.println(m.getId()+" "
                +m.getMessage()+ " "+m.getPseudo());
                
            }
        } catch (Exception e) {
            System.out.println("BD.Bd.main() :"+e.getMessage());
        }
        
                
        
    }
   
    
}
