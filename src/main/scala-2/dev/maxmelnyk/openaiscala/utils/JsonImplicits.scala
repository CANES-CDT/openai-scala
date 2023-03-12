package dev.maxmelnyk.openaiscala.utils

import dev.maxmelnyk.openaiscala.models.settings.{CreateChatCompletionSettings, CreateCompletionSettings}
import dev.maxmelnyk.openaiscala.models.{ChatCompletion, Completion, ModelInfo}
import io.circe.{Decoder, Encoder}
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveConfiguredDecoder, deriveConfiguredEncoder}

private[openaiscala] object JsonImplicits extends CommonJsonImplicits {
  private implicit val config: Configuration = Configuration.default.withSnakeCaseMemberNames

  // models
  implicit val modelPermissionDecoder: Decoder[ModelInfo.Permission] = deriveConfiguredDecoder
  implicit val modelDecoder: Decoder[ModelInfo] = deriveConfiguredDecoder

  // completions
  implicit val completionChoiceLogprobsDecoder: Decoder[Completion.Choice.Logprobs] = deriveConfiguredDecoder
  implicit val completionChoiceDecoder: Decoder[Completion.Choice] = deriveConfiguredDecoder
  implicit val completionUsageDecoder: Decoder[Completion.Usage] = deriveConfiguredDecoder
  implicit val completionDecoder: Decoder[Completion] = deriveConfiguredDecoder

  implicit val createCompletionSettingsEncoder: Encoder[CreateCompletionSettings] = deriveConfiguredEncoder

  // chat completions
  implicit val chatCompletionMessageEncoder: Encoder[ChatCompletion.Message] = deriveConfiguredEncoder
  implicit val chatCompletionMessageDecoder: Decoder[ChatCompletion.Message] = deriveConfiguredDecoder

  implicit val chatCompletionChoiceDecoder: Decoder[ChatCompletion.Choice] = deriveConfiguredDecoder
  implicit val chatCompletionUsageDecoder: Decoder[ChatCompletion.Usage] = deriveConfiguredDecoder
  implicit val chatCompletionDecoder: Decoder[ChatCompletion] = deriveConfiguredDecoder

  implicit val createChatCompletionSettingsEncoder: Encoder[CreateChatCompletionSettings] = deriveConfiguredEncoder
}
