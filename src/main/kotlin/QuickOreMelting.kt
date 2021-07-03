import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.BlastingRecipe
import org.bukkit.inventory.FurnaceRecipe
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class QuickOreMelting : JavaPlugin(){

    override fun onEnable() {
        addFurnaceRecipes()
    }

    private fun addFurnaceRecipes() {
        val ores: Array<String> = arrayOf("IRON", "GOLD", "COPPER")

        ores.forEach { ore ->
            val key = NamespacedKey(this, "quick"+ore+"Recipe")
            val source: Material = Material.getMaterial("RAW_"+ore+"_BLOCK")!!
            val result: ItemStack = ItemStack(Material.getMaterial(ore + "_BLOCK")!!)
            val experience: Float = 7.0F
            val cookingTime: Int = 1600
            server.addRecipe(FurnaceRecipe(key, result, source, experience, cookingTime))
            server.addRecipe(BlastingRecipe(key, result, source, experience, cookingTime / 2))
        }
    }
}