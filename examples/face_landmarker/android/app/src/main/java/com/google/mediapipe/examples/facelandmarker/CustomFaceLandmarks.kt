package com.google.mediapipe.examples.facelandmarker

import com.google.mediapipe.tasks.components.containers.Connection

class CustomFaceLandmarks {

    // Define the indices for the lip landmarks based on MediaPipe's face mesh model
    private val lowerLipIndices = listOf(
        61, 146, 91, 181, 84, 17, 314, 405, 321, 375, 291, 308, 324, 318, 402, 317, 14, 87, 178, 88, 95, 78
    )

    private val upperLipIndices = listOf(
        61, 185, 40, 39, 37, 0, 267, 269, 270, 409, 291, 308, 415, 310, 311, 312, 13, 82, 81, 80, 191, 78
    )

    // Create connections for the upper and lower lips
    val faceLandmarksLowerLipsCustom: Set<Connection> = lowerLipIndices.zipWithNext { a, b ->
        Connection.create(a, b)
    }.toSet() + setOf(Connection.create(lowerLipIndices.last(), lowerLipIndices.first()))

    val faceLandmarksUpperLipsCustom: Set<Connection> = upperLipIndices.zipWithNext { a, b ->
        Connection.create(a, b)
    }.toSet() + setOf(Connection.create(upperLipIndices.last(), upperLipIndices.first()))

    companion object {
        // Expose FACE_LANDMARKS_LIPS_CUSTOM through companion object for easy access
        val FACE_LANDMARKS_LOWER_LIPS_CUSTOM by lazy {
            CustomFaceLandmarks().faceLandmarksLowerLipsCustom
        }

        val FACE_LANDMARKS_UPPER_LIPS_CUSTOM by lazy {
            CustomFaceLandmarks().faceLandmarksUpperLipsCustom
        }
    }


//    bottom lip bottom line
//    (61, 146), (146, 91), (91, 181), (181, 84), (84, 17),(17, 314), (314, 405), (405, 321), (321, 375),(375, 291)
//
//    bottom lip upper line
//    (78, 95), (95, 88), (88, 178), (178, 87), (87, 14),  (14, 317), (317, 402), (402, 318), (318, 324), (324, 308),
//
//    upper lip upper line
//    (61, 185), (185, 40), (40, 39),  (39, 37),  (37, 0), (0, 267),  (267, 269), (269, 270), (270, 409), (409, 291)
//
//    upper lip bottom line
//    (78, 191), (191, 80), (80, 81),  (81, 82),  (82, 13), (13, 312), (312, 311), (311, 310), (310, 415), (415, 308)
}