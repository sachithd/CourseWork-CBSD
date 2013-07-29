
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindRangeAddressResponse_QNAME = new QName("http://webservices/", "findRangeAddressResponse");
    private final static QName _RemoveAddress_QNAME = new QName("http://webservices/", "removeAddress");
    private final static QName _FindCountryResponse_QNAME = new QName("http://webservices/", "findCountryResponse");
    private final static QName _CreateAddress_QNAME = new QName("http://webservices/", "createAddress");
    private final static QName _RemoveCountry_QNAME = new QName("http://webservices/", "removeCountry");
    private final static QName _FindAddress_QNAME = new QName("http://webservices/", "findAddress");
    private final static QName _Address_QNAME = new QName("http://webservices/", "address");
    private final static QName _CountCustomerResponse_QNAME = new QName("http://webservices/", "countCustomerResponse");
    private final static QName _EditCustomer_QNAME = new QName("http://webservices/", "editCustomer");
    private final static QName _CountAddress_QNAME = new QName("http://webservices/", "countAddress");
    private final static QName _Country_QNAME = new QName("http://webservices/", "country");
    private final static QName _FindRangeCustomerResponse_QNAME = new QName("http://webservices/", "findRangeCustomerResponse");
    private final static QName _Customers_QNAME = new QName("http://webservices/", "customers");
    private final static QName _FindAllCustomerResponse_QNAME = new QName("http://webservices/", "findAllCustomerResponse");
    private final static QName _CountAddressResponse_QNAME = new QName("http://webservices/", "countAddressResponse");
    private final static QName _FindCountry_QNAME = new QName("http://webservices/", "findCountry");
    private final static QName _FindCustomerResponse_QNAME = new QName("http://webservices/", "findCustomerResponse");
    private final static QName _FindRangeCountry_QNAME = new QName("http://webservices/", "findRangeCountry");
    private final static QName _FindAllAddress_QNAME = new QName("http://webservices/", "findAllAddress");
    private final static QName _CreateCountry_QNAME = new QName("http://webservices/", "createCountry");
    private final static QName _FindAllCountry_QNAME = new QName("http://webservices/", "findAllCountry");
    private final static QName _EditAddress_QNAME = new QName("http://webservices/", "editAddress");
    private final static QName _CountCountryResponse_QNAME = new QName("http://webservices/", "countCountryResponse");
    private final static QName _FindAllCustomer_QNAME = new QName("http://webservices/", "findAllCustomer");
    private final static QName _FindRangeAddress_QNAME = new QName("http://webservices/", "findRangeAddress");
    private final static QName _CountCustomer_QNAME = new QName("http://webservices/", "countCustomer");
    private final static QName _CountCountry_QNAME = new QName("http://webservices/", "countCountry");
    private final static QName _CreateCustomer_QNAME = new QName("http://webservices/", "createCustomer");
    private final static QName _FindRangeCountryResponse_QNAME = new QName("http://webservices/", "findRangeCountryResponse");
    private final static QName _EditCountry_QNAME = new QName("http://webservices/", "editCountry");
    private final static QName _FindAllCountryResponse_QNAME = new QName("http://webservices/", "findAllCountryResponse");
    private final static QName _FindAllAddressResponse_QNAME = new QName("http://webservices/", "findAllAddressResponse");
    private final static QName _RemoveCustomer_QNAME = new QName("http://webservices/", "removeCustomer");
    private final static QName _FindCustomer_QNAME = new QName("http://webservices/", "findCustomer");
    private final static QName _FindAddressResponse_QNAME = new QName("http://webservices/", "findAddressResponse");
    private final static QName _FindRangeCustomer_QNAME = new QName("http://webservices/", "findRangeCustomer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAddressResponse }
     * 
     */
    public FindAddressResponse createFindAddressResponse() {
        return new FindAddressResponse();
    }

    /**
     * Create an instance of {@link FindAllCustomer }
     * 
     */
    public FindAllCustomer createFindAllCustomer() {
        return new FindAllCustomer();
    }

    /**
     * Create an instance of {@link FindRangeAddress }
     * 
     */
    public FindRangeAddress createFindRangeAddress() {
        return new FindRangeAddress();
    }

    /**
     * Create an instance of {@link CountCustomer }
     * 
     */
    public CountCustomer createCountCustomer() {
        return new CountCustomer();
    }

    /**
     * Create an instance of {@link FindRangeCountry }
     * 
     */
    public FindRangeCountry createFindRangeCountry() {
        return new FindRangeCountry();
    }

    /**
     * Create an instance of {@link CountAddress }
     * 
     */
    public CountAddress createCountAddress() {
        return new CountAddress();
    }

    /**
     * Create an instance of {@link FindCountry }
     * 
     */
    public FindCountry createFindCountry() {
        return new FindCountry();
    }

    /**
     * Create an instance of {@link FindCountryResponse }
     * 
     */
    public FindCountryResponse createFindCountryResponse() {
        return new FindCountryResponse();
    }

    /**
     * Create an instance of {@link RemoveCustomer }
     * 
     */
    public RemoveCustomer createRemoveCustomer() {
        return new RemoveCustomer();
    }

    /**
     * Create an instance of {@link FindAllAddress }
     * 
     */
    public FindAllAddress createFindAllAddress() {
        return new FindAllAddress();
    }

    /**
     * Create an instance of {@link EditCustomer }
     * 
     */
    public EditCustomer createEditCustomer() {
        return new EditCustomer();
    }

    /**
     * Create an instance of {@link Customers }
     * 
     */
    public Customers createCustomers() {
        return new Customers();
    }

    /**
     * Create an instance of {@link CreateCustomer }
     * 
     */
    public CreateCustomer createCreateCustomer() {
        return new CreateCustomer();
    }

    /**
     * Create an instance of {@link CountAddressResponse }
     * 
     */
    public CountAddressResponse createCountAddressResponse() {
        return new CountAddressResponse();
    }

    /**
     * Create an instance of {@link FindAddress }
     * 
     */
    public FindAddress createFindAddress() {
        return new FindAddress();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link EditCountry }
     * 
     */
    public EditCountry createEditCountry() {
        return new EditCountry();
    }

    /**
     * Create an instance of {@link EditAddress }
     * 
     */
    public EditAddress createEditAddress() {
        return new EditAddress();
    }

    /**
     * Create an instance of {@link FindRangeCountryResponse }
     * 
     */
    public FindRangeCountryResponse createFindRangeCountryResponse() {
        return new FindRangeCountryResponse();
    }

    /**
     * Create an instance of {@link FindAllCustomerResponse }
     * 
     */
    public FindAllCustomerResponse createFindAllCustomerResponse() {
        return new FindAllCustomerResponse();
    }

    /**
     * Create an instance of {@link CountCustomerResponse }
     * 
     */
    public CountCustomerResponse createCountCustomerResponse() {
        return new CountCustomerResponse();
    }

    /**
     * Create an instance of {@link CreateAddress }
     * 
     */
    public CreateAddress createCreateAddress() {
        return new CreateAddress();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link FindCustomerResponse }
     * 
     */
    public FindCustomerResponse createFindCustomerResponse() {
        return new FindCustomerResponse();
    }

    /**
     * Create an instance of {@link RemoveCountry }
     * 
     */
    public RemoveCountry createRemoveCountry() {
        return new RemoveCountry();
    }

    /**
     * Create an instance of {@link FindRangeCustomer }
     * 
     */
    public FindRangeCustomer createFindRangeCustomer() {
        return new FindRangeCustomer();
    }

    /**
     * Create an instance of {@link CreateCountry }
     * 
     */
    public CreateCountry createCreateCountry() {
        return new CreateCountry();
    }

    /**
     * Create an instance of {@link FindAllCountry }
     * 
     */
    public FindAllCountry createFindAllCountry() {
        return new FindAllCountry();
    }

    /**
     * Create an instance of {@link FindRangeAddressResponse }
     * 
     */
    public FindRangeAddressResponse createFindRangeAddressResponse() {
        return new FindRangeAddressResponse();
    }

    /**
     * Create an instance of {@link FindRangeCustomerResponse }
     * 
     */
    public FindRangeCustomerResponse createFindRangeCustomerResponse() {
        return new FindRangeCustomerResponse();
    }

    /**
     * Create an instance of {@link FindAllCountryResponse }
     * 
     */
    public FindAllCountryResponse createFindAllCountryResponse() {
        return new FindAllCountryResponse();
    }

    /**
     * Create an instance of {@link FindCustomer }
     * 
     */
    public FindCustomer createFindCustomer() {
        return new FindCustomer();
    }

    /**
     * Create an instance of {@link RemoveAddress }
     * 
     */
    public RemoveAddress createRemoveAddress() {
        return new RemoveAddress();
    }

    /**
     * Create an instance of {@link CountCountryResponse }
     * 
     */
    public CountCountryResponse createCountCountryResponse() {
        return new CountCountryResponse();
    }

    /**
     * Create an instance of {@link CountCountry }
     * 
     */
    public CountCountry createCountCountry() {
        return new CountCountry();
    }

    /**
     * Create an instance of {@link FindAllAddressResponse }
     * 
     */
    public FindAllAddressResponse createFindAllAddressResponse() {
        return new FindAllAddressResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findRangeAddressResponse")
    public JAXBElement<FindRangeAddressResponse> createFindRangeAddressResponse(FindRangeAddressResponse value) {
        return new JAXBElement<FindRangeAddressResponse>(_FindRangeAddressResponse_QNAME, FindRangeAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "removeAddress")
    public JAXBElement<RemoveAddress> createRemoveAddress(RemoveAddress value) {
        return new JAXBElement<RemoveAddress>(_RemoveAddress_QNAME, RemoveAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findCountryResponse")
    public JAXBElement<FindCountryResponse> createFindCountryResponse(FindCountryResponse value) {
        return new JAXBElement<FindCountryResponse>(_FindCountryResponse_QNAME, FindCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "createAddress")
    public JAXBElement<CreateAddress> createCreateAddress(CreateAddress value) {
        return new JAXBElement<CreateAddress>(_CreateAddress_QNAME, CreateAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "removeCountry")
    public JAXBElement<RemoveCountry> createRemoveCountry(RemoveCountry value) {
        return new JAXBElement<RemoveCountry>(_RemoveCountry_QNAME, RemoveCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findAddress")
    public JAXBElement<FindAddress> createFindAddress(FindAddress value) {
        return new JAXBElement<FindAddress>(_FindAddress_QNAME, FindAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "countCustomerResponse")
    public JAXBElement<CountCustomerResponse> createCountCustomerResponse(CountCustomerResponse value) {
        return new JAXBElement<CountCustomerResponse>(_CountCustomerResponse_QNAME, CountCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "editCustomer")
    public JAXBElement<EditCustomer> createEditCustomer(EditCustomer value) {
        return new JAXBElement<EditCustomer>(_EditCustomer_QNAME, EditCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "countAddress")
    public JAXBElement<CountAddress> createCountAddress(CountAddress value) {
        return new JAXBElement<CountAddress>(_CountAddress_QNAME, CountAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "country")
    public JAXBElement<Country> createCountry(Country value) {
        return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findRangeCustomerResponse")
    public JAXBElement<FindRangeCustomerResponse> createFindRangeCustomerResponse(FindRangeCustomerResponse value) {
        return new JAXBElement<FindRangeCustomerResponse>(_FindRangeCustomerResponse_QNAME, FindRangeCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "customers")
    public JAXBElement<Customers> createCustomers(Customers value) {
        return new JAXBElement<Customers>(_Customers_QNAME, Customers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findAllCustomerResponse")
    public JAXBElement<FindAllCustomerResponse> createFindAllCustomerResponse(FindAllCustomerResponse value) {
        return new JAXBElement<FindAllCustomerResponse>(_FindAllCustomerResponse_QNAME, FindAllCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "countAddressResponse")
    public JAXBElement<CountAddressResponse> createCountAddressResponse(CountAddressResponse value) {
        return new JAXBElement<CountAddressResponse>(_CountAddressResponse_QNAME, CountAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findCountry")
    public JAXBElement<FindCountry> createFindCountry(FindCountry value) {
        return new JAXBElement<FindCountry>(_FindCountry_QNAME, FindCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findCustomerResponse")
    public JAXBElement<FindCustomerResponse> createFindCustomerResponse(FindCustomerResponse value) {
        return new JAXBElement<FindCustomerResponse>(_FindCustomerResponse_QNAME, FindCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findRangeCountry")
    public JAXBElement<FindRangeCountry> createFindRangeCountry(FindRangeCountry value) {
        return new JAXBElement<FindRangeCountry>(_FindRangeCountry_QNAME, FindRangeCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findAllAddress")
    public JAXBElement<FindAllAddress> createFindAllAddress(FindAllAddress value) {
        return new JAXBElement<FindAllAddress>(_FindAllAddress_QNAME, FindAllAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "createCountry")
    public JAXBElement<CreateCountry> createCreateCountry(CreateCountry value) {
        return new JAXBElement<CreateCountry>(_CreateCountry_QNAME, CreateCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findAllCountry")
    public JAXBElement<FindAllCountry> createFindAllCountry(FindAllCountry value) {
        return new JAXBElement<FindAllCountry>(_FindAllCountry_QNAME, FindAllCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "editAddress")
    public JAXBElement<EditAddress> createEditAddress(EditAddress value) {
        return new JAXBElement<EditAddress>(_EditAddress_QNAME, EditAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "countCountryResponse")
    public JAXBElement<CountCountryResponse> createCountCountryResponse(CountCountryResponse value) {
        return new JAXBElement<CountCountryResponse>(_CountCountryResponse_QNAME, CountCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findAllCustomer")
    public JAXBElement<FindAllCustomer> createFindAllCustomer(FindAllCustomer value) {
        return new JAXBElement<FindAllCustomer>(_FindAllCustomer_QNAME, FindAllCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findRangeAddress")
    public JAXBElement<FindRangeAddress> createFindRangeAddress(FindRangeAddress value) {
        return new JAXBElement<FindRangeAddress>(_FindRangeAddress_QNAME, FindRangeAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "countCustomer")
    public JAXBElement<CountCustomer> createCountCustomer(CountCustomer value) {
        return new JAXBElement<CountCustomer>(_CountCustomer_QNAME, CountCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "countCountry")
    public JAXBElement<CountCountry> createCountCountry(CountCountry value) {
        return new JAXBElement<CountCountry>(_CountCountry_QNAME, CountCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "createCustomer")
    public JAXBElement<CreateCustomer> createCreateCustomer(CreateCustomer value) {
        return new JAXBElement<CreateCustomer>(_CreateCustomer_QNAME, CreateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findRangeCountryResponse")
    public JAXBElement<FindRangeCountryResponse> createFindRangeCountryResponse(FindRangeCountryResponse value) {
        return new JAXBElement<FindRangeCountryResponse>(_FindRangeCountryResponse_QNAME, FindRangeCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "editCountry")
    public JAXBElement<EditCountry> createEditCountry(EditCountry value) {
        return new JAXBElement<EditCountry>(_EditCountry_QNAME, EditCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCountryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findAllCountryResponse")
    public JAXBElement<FindAllCountryResponse> createFindAllCountryResponse(FindAllCountryResponse value) {
        return new JAXBElement<FindAllCountryResponse>(_FindAllCountryResponse_QNAME, FindAllCountryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findAllAddressResponse")
    public JAXBElement<FindAllAddressResponse> createFindAllAddressResponse(FindAllAddressResponse value) {
        return new JAXBElement<FindAllAddressResponse>(_FindAllAddressResponse_QNAME, FindAllAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "removeCustomer")
    public JAXBElement<RemoveCustomer> createRemoveCustomer(RemoveCustomer value) {
        return new JAXBElement<RemoveCustomer>(_RemoveCustomer_QNAME, RemoveCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findCustomer")
    public JAXBElement<FindCustomer> createFindCustomer(FindCustomer value) {
        return new JAXBElement<FindCustomer>(_FindCustomer_QNAME, FindCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findAddressResponse")
    public JAXBElement<FindAddressResponse> createFindAddressResponse(FindAddressResponse value) {
        return new JAXBElement<FindAddressResponse>(_FindAddressResponse_QNAME, FindAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "findRangeCustomer")
    public JAXBElement<FindRangeCustomer> createFindRangeCustomer(FindRangeCustomer value) {
        return new JAXBElement<FindRangeCustomer>(_FindRangeCustomer_QNAME, FindRangeCustomer.class, null, value);
    }

}
