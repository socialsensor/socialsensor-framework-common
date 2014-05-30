/*
 * Copyright 2014 stzoannos.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.socialsensor.framework.common.domain;

import eu.socialsensor.framework.common.domain.dysco.Dysco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stzoannos
 */
public class TrendsMatcherResponse {
    
    List<Dysco> newDyscos = new ArrayList<Dysco>();
    List<String> dyscoIdsToDelete = new ArrayList<String>();

    public List<Dysco> getNewDyscos() {
        return newDyscos;
    }

    public void setNewDyscos(List<Dysco> newDyscos) {
        this.newDyscos = newDyscos;
    }

    public List<String> getDyscoIdsToDelete() {
        return dyscoIdsToDelete;
    }

    public void setDyscoIdsToDelete(List<String> dyscoIdsToDelete) {
        this.dyscoIdsToDelete = dyscoIdsToDelete;
    }
    
    
    
    
    
}
