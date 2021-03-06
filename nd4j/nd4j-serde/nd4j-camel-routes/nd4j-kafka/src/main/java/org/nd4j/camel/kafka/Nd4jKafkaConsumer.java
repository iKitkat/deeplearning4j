/*******************************************************************************
 * Copyright (c) 2015-2018 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.nd4j.camel.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Created by agibsonccc on 7/19/16.
 */
@AllArgsConstructor
@Builder
public class Nd4jKafkaConsumer {
    private KafkaConnectionInformation connectionInformation;
    private ConsumerTemplate consumerTemplate;
    private CamelContext camelContext;

    /**
     * Receive an ndarray
     * @return
     */
    public INDArray receive() {
        if (consumerTemplate == null)
            consumerTemplate = camelContext.createConsumerTemplate();
        return consumerTemplate.receiveBody("direct:receive", INDArray.class);
    }

}
