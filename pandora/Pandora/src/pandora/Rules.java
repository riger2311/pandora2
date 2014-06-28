/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pandora;

/**
 *
 * @author dominikmocher
 */
public class Rules {
    
      Boolean rolling;

    public Rules() {
        this.rolling = false;
    }
      
      
      void setRolling(Boolean value)
      {
          this.rolling = value;
      }
      
      Boolean getRolling()
      {
          return this.rolling;
      }
    
}
