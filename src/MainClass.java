import org.apache.xerces.util.SecurityManager;
import java.util.ArrayList;

public class MainClass {
	public static void main(String[] args) {
		ReadXml readXml = new ReadXml();
		readXml.getXml();
		//SplitCSV split = new SplitCSV();
		SecurityManager securityManager = new SecurityManager();
		// securityManager.setEntityExpansionLimit(ENTITY_EXPANSION_LIMIT);
		securityManager.setEntityExpansionLimit(0);
		// documentBuilderFactory.setAttribute(SECURITY_MANAGER_PROPERTY, securityManager);

		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				System.out.println("tio cut");
			}
		});
		 }

	public void setProperty(String propertyId, Object value)
    throws XMLConfigurationException {

    // Xerces properties
    if (propertyId.startsWith(Constants.XERCES_PROPERTY_PREFIX)) {
        final int suffixLength = propertyId.length() - Constants.XERCES_PROPERTY_PREFIX.length();
    	
        if (suffixLength == Constants.SYMBOL_TABLE_PROPERTY.length() && 
            propertyId.endsWith(Constants.SYMBOL_TABLE_PROPERTY)) {
            fSymbolTable = (SymbolTable)value;
            return;
        }
        if (suffixLength == Constants.ERROR_REPORTER_PROPERTY.length() && 
            propertyId.endsWith(Constants.ERROR_REPORTER_PROPERTY)) {
            fErrorReporter = (XMLErrorReporter)value;
            return;
        }
        if (suffixLength == Constants.ENTITY_RESOLVER_PROPERTY.length() && 
            propertyId.endsWith(Constants.ENTITY_RESOLVER_PROPERTY)) {
            fEntityResolver = (XMLEntityResolver)value;
            return;
        }
        if (suffixLength == Constants.BUFFER_SIZE_PROPERTY.length() && 
            propertyId.endsWith(Constants.BUFFER_SIZE_PROPERTY)) {
            Integer bufferSize = (Integer)value;
            if (bufferSize != null &&
                bufferSize.intValue() > DEFAULT_XMLDECL_BUFFER_SIZE) {
                fBufferSize = bufferSize.intValue();
                fEntityScanner.setBufferSize(fBufferSize);
                fSmallByteBufferPool.setBufferSize(fBufferSize);
                fLargeByteBufferPool.setBufferSize(fBufferSize << 1);
                fCharacterBufferPool.setExternalBufferSize(fBufferSize);
            }
        }
        if (suffixLength == Constants.SECURITY_MANAGER_PROPERTY.length() && 
            propertyId.endsWith(Constants.SECURITY_MANAGER_PROPERTY)) {
            fSecurityManager = (SecurityManager)value; 
            fEntityExpansionLimit = (fSecurityManager != null)?fSecurityManager.getEntityExpansionLimit():0;
        }
    }

}


}
