package ke.ac.emerg.util

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration

object CONSTANTS {

    private val regexPattern = """\b[\w.-]+@s\.karu\.ac\.ke\b""".toRegex()
    private val BASE_URL = "https://472d-105-163-157-60.ngrok-free.app"

    @Composable
    fun getShimmerBrush(): Brush {
        val shimmerColors = listOf(
            Color.LightGray.copy(0.6f),
            Color.LightGray.copy(0.2f),
            Color.LightGray.copy(0.6f),
        )

        val transition = rememberInfiniteTransition(label = "")

        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
            ), label = ""
        )

        val brush = Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )

        return brush
    }


}
