package org.shop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The main Data Initializer util class.
 */
@Component("dataInitializer")
public class DataInitializer {

    /** The seller initializer. */
	@Autowired
    private SellerInitializer sellerInitializer;
    
    /** The product initializer. */
	@Autowired
    private ProductInitializer productInitializer;
    
    /** The proposal initializer. */
	@Autowired
    private ProposalInitializer proposalInitializer;
    
    /** The user initializer. */
	@Autowired
    private UserInitializer userInitializer;

    /**
     * Inits the data.
     */
    @PostConstruct
    public void initData() {
        sellerInitializer.initSellers();
        userInitializer.initUsers();
        productInitializer.initProducts();
        proposalInitializer.initProposals();
    }
    
    /**
     * Sets the seller initializer.
     *
     * @param sellerInitializer the new seller initializer
     */
    public void setSellerInitializer(SellerInitializer sellerInitializer) {
        this.sellerInitializer = sellerInitializer;
    }

    /**
     * Sets the product initializer.
     *
     * @param productInitializer the new product initializer
     */
    public void setProductInitializer(ProductInitializer productInitializer) {
        this.productInitializer = productInitializer;
    }

    /**
     * Sets the proposal initializer.
     *
     * @param proposalInitializer the new proposal initializer
     */
    public void setProposalInitializer(ProposalInitializer proposalInitializer) {
        this.proposalInitializer = proposalInitializer;
    }

    /**
     * Sets the user initializer.
     *
     * @param userInitializer the new user initializer
     */
    public void setUserInitializer(UserInitializer userInitializer) {
        this.userInitializer = userInitializer;
    }
}
