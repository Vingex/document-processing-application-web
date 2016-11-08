/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Алексей
 */
public class DocumentExistsException extends Exception{
        public DocumentExistsException(String message){     
        super(message);
    }
}
