/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author lucidarme
 */

import javax.ws.rs.*;

@Path("/bienvenue")
public class Bienvenue {    
   @GET   
   @Produces("text/plain")   
   public String getMessage() {      
      return "Bienvenue... (premier exemple REST)";   
   }
}
