package DateTime;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public enum DateFormatter {

    HHMMSS_24HRS("HHmmss"),
    HHMM_WITHCOLON("HH:mm"),
    YYYYMMDD_WITHYPWITHTIME("yyyy-MM-dd HH:mm:ss.S"),
    HHMM_WITHOUTCOLON("HHmm"),
    DDMMYYYY_WITHSLASH("dd/MM/yyyy"),
    MMDDYYYY_WITHSLASH("MM/dd/yyyy"),
    DDMMMYYYY_WITHHYP("dd-MMM-yyyy"),
    DDMMMYYYY_HH_MM_WITHHYP("dd-MMM-yyyy HH:mm"),
    DDMMMYYYY_HH_MM("dd-MMM-yyyy HHmm"),
    DDMMMYYYY_HH_MM_SS("d-MMM-yyyy HHmmss"),
    DDMMMYY_WITHHYP("dd-MMM-yy"),
    YYYYMMDD_WITHYP("yyyy-MM-dd"),
    YYYYMMDD_WITHTIMEHYP("yyyy-MM-dd HH:mm"),
    ISO_WITH_TIMEZONE("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"),
	DDMMYYYY_SECS("dd-MM-yyyy HH:mm:ss.SSS"),
	DDMMMYY_HH_MM_SS_WITHHYP("dd-MMM-yy HH.mm.ss.SSSSSSSSS a");
	
    private final String formatString;

    DateFormatter(String format){
        formatString = format;
    }
    public DateTimeFormatter formatter(){
        return this.formatter(DateTimeFormatter.class);
    }

    public <T> T formatter(Class<T> formatter) {
        if(formatter.getName().equalsIgnoreCase(SimpleDateFormat.class.getName())){
            return formatter.cast(new SimpleDateFormat(getFormatString()));
        }

        if(formatter.getName().equalsIgnoreCase(DateTimeFormatter.class.getName())){
            return formatter.cast(DateTimeFormatter.ofPattern(getFormatString()));
        }
        return null;
    }
    
    public  String getFormatString() {
        return formatString;
    }
    
    public enum TIMEZONE {

		H("Hawaii","US/Hawaii","HST"),
		Y("Alaska","US/Alaska","AST"),
		P("Pacific","US/Pacific","PST") ,
		M("Mountain","US/Mountain","MST"), 
		C("Central","US/Central","CST"),
		E("Eastern","US/Eastern","EST"),
		UTC("UTC","UTC","UTC"),
		DEFAULT("Default","US/Central","CST") ;

    	private final String desc;
        private final String zoneString;
        private final String dstZoneString;
        
        public String getDesc() {
            return desc;
        }
        
        private TIMEZONE(String description, String zoneString, String dstZoneString) {
            this.desc = description;
            this.zoneString = zoneString;
            this.dstZoneString = dstZoneString;
        }
        
		public ZoneId zone() {
			return ZoneId.of(zoneString);
		}

//		public TimeZone timeZone(String dst) {
//			return dst.equalsIgnoreCase(Constants.YES_INDICATOR)
//					? TimeZone.getTimeZone(ZoneId.of(zoneString))
//					: TimeZone.getTimeZone(dstZoneString);
//		}

	}
}
