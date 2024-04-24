package org.jason.utils.ktor

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive

object MessageSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("MessageSerializer") {
            element<String>("message", isOptional = true)
        }

    override fun serialize(encoder: Encoder, value: String) {
        encoder.encodeString(value)
    }

    override fun deserialize(decoder: Decoder): String {
        val element = (decoder as? JsonDecoder)?.decodeJsonElement()
            ?: throw SerializationException("Decoder is not compatible with JsonDecoder")

        return when (element) {
            is JsonPrimitive -> element.content  // Directly use the single string
            is JsonArray -> element.jsonArray.joinToString(separator = ", ") {
                it.jsonPrimitive.content  // Join array elements into a single string
            }
            else -> throw SerializationException("Expected JsonPrimitive or JsonArray for message field")
        }
    }
}