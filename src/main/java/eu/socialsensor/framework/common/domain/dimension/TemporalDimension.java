/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.socialsensor.framework.common.domain.dimension;

import eu.socialsensor.framework.common.domain.*;
import java.util.Date;
/**
 *
 * @author etzoannos
 */
public class TemporalDimension implements Dimension {
    
    
    Date start; 
    Date end;
    Timeline timeline;

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
    
    
    
    
}
