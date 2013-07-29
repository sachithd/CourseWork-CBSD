/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerlStratford;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Address;

/**
 * Session bean class for entity bean Address class (Stratford Database)
 * @see Address
 * @author Sachith
 */
@Stateless
public class AddressFacadeSt extends AbstractFacadeSt<Address> {
    @PersistenceContext(unitName = "CustomerManagementStratfordPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacadeSt() {
        super(Address.class);
    }
    
}
