package eu.socialsensor.framework.common.domain.geo;

/**
 * COMMENT: Should be replaced by LatLng class in Lucene Spatial.
 *  This class presents a model for storing GeoLocation information
 * @author etzoannos
 */
public class GeoLocation {
    
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    
    
}
