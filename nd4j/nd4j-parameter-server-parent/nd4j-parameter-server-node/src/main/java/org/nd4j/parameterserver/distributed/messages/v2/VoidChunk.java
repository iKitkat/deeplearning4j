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

package org.nd4j.parameterserver.distributed.messages.v2;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoidChunk implements VoidMessage_v2 {
    /**
     * This field contains position of this chunk in merger
     */
    @Getter
    private int chunkId;

    /**
     * This field contains number of bytes of original message
     */
    @Getter
    private long totalSize;

    /**
     * Unique messageId used to distringuish chunks from each other
     */
    @Getter
    private String messageId;

    /**
     * This field holds ID of the original message
     */
    @Getter
    private String originalId;

    /**
     * This field holds number of chunks for original message
     */
    @Getter
    private int numberOfChunks;

    /**
     * Actual chunk
     */
    @Getter
    private byte[] payload;


    public void exec() {
        // basically all we want to do here, is merge
    }
}
