package su.nightexpress.quantumrpg.modules;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import su.nightexpress.quantumrpg.QuantumRPG;
import su.nightexpress.quantumrpg.modules.list.arrows.ArrowManager;
import su.nightexpress.quantumrpg.modules.list.classes.ClassManager;
import su.nightexpress.quantumrpg.modules.list.combatlog.CombatLogManager;
import su.nightexpress.quantumrpg.modules.list.dismantle.DismantleManager;
import su.nightexpress.quantumrpg.modules.list.drops.DropManager;
import su.nightexpress.quantumrpg.modules.list.essences.EssencesManager;
import su.nightexpress.quantumrpg.modules.list.extractor.ExtractorManager;
import su.nightexpress.quantumrpg.modules.list.fortify.FortifyManager;
import su.nightexpress.quantumrpg.modules.list.gems.GemManager;
import su.nightexpress.quantumrpg.modules.list.identify.IdentifyManager;
import su.nightexpress.quantumrpg.modules.list.itemgenerator.ItemGeneratorManager;
import su.nightexpress.quantumrpg.modules.list.itemhints.ItemHintsManager;
import su.nightexpress.quantumrpg.modules.list.loot.LootManager;
import su.nightexpress.quantumrpg.modules.list.magicdust.MagicDustManager;
import su.nightexpress.quantumrpg.modules.list.party.PartyManager;
import su.nightexpress.quantumrpg.modules.list.refine.RefineManager;
import su.nightexpress.quantumrpg.modules.list.repair.RepairManager;
import su.nightexpress.quantumrpg.modules.list.runes.RuneManager;
import su.nightexpress.quantumrpg.modules.list.sell.SellManager;
import su.nightexpress.quantumrpg.modules.list.sets.SetManager;
import su.nightexpress.quantumrpg.modules.list.soulbound.SoulboundManager;

public class ModuleCache {
	
	private QuantumRPG plugin;
	
	private GemManager gemsManager;
	private EssencesManager essencesManager;
	private RuneManager runesManager;
	private MagicDustManager magicDustManager;
	private ArrowManager arrowManager;
	private SetManager setManager;
	private ItemGeneratorManager itemGeneratorManager;
	
	private ClassManager classManager;
	
	private RefineManager refineManager;
	private FortifyManager fortifyManager;
	private IdentifyManager identifyManager;
	private SoulboundManager soulboundManager;
	private RepairManager repairManager;
	private DismantleManager dismantleManager;
	private ExtractorManager extractorManager;
	private PartyManager partyManager;
	private ItemHintsManager itemHintsManager;
	
	private DropManager dropManager;
	private LootManager lootManager;
	
	private SellManager sellManager;
	private CombatLogManager combatLogManager;
	
	public ModuleCache(@NotNull QuantumRPG plugin) {
		this.plugin = plugin;
	}
	
	public void initialize() {
		this.gemsManager = this.plugin.getModuleManager().register(new GemManager(plugin));
		this.essencesManager = this.plugin.getModuleManager().register(new EssencesManager(plugin));
		this.runesManager = this.plugin.getModuleManager().register(new RuneManager(plugin));
		this.arrowManager = this.plugin.getModuleManager().register(new ArrowManager(plugin));
		this.setManager = this.plugin.getModuleManager().register(new SetManager(plugin));
		this.itemGeneratorManager = this.plugin.getModuleManager().register(new ItemGeneratorManager(plugin));
		
		this.classManager = this.plugin.getModuleManager().register(new ClassManager(plugin));
		
		// Utility
		this.refineManager = this.plugin.getModuleManager().register(new RefineManager(plugin));
		this.fortifyManager = this.plugin.getModuleManager().register(new FortifyManager(plugin));
		this.identifyManager = this.plugin.getModuleManager().register(new IdentifyManager(plugin));
		this.magicDustManager = this.plugin.getModuleManager().register(new MagicDustManager(plugin));
		this.soulboundManager = this.plugin.getModuleManager().register(new SoulboundManager(plugin));
		this.repairManager = this.plugin.getModuleManager().register(new RepairManager(plugin));
		this.dismantleManager = this.plugin.getModuleManager().register(new DismantleManager(plugin));
		this.extractorManager = this.plugin.getModuleManager().register(new ExtractorManager(plugin));
		this.partyManager = this.plugin.getModuleManager().register(new PartyManager(plugin));
		this.itemHintsManager = this.plugin.getModuleManager().register(new ItemHintsManager(plugin));
		
		this.dropManager = this.plugin.getModuleManager().register(new DropManager(plugin));
		this.lootManager = this.plugin.getModuleManager().register(new LootManager(plugin));
		
		this.sellManager = this.plugin.getModuleManager().register(new SellManager(plugin));
		this.combatLogManager = this.plugin.getModuleManager().register(new CombatLogManager(plugin));
	}
	
	public void shutdown() {
		this.gemsManager = null;
		this.essencesManager = null;
		this.runesManager = null;
		this.magicDustManager = null;
		this.arrowManager = null;
		this.setManager = null;
		this.itemGeneratorManager = null;
		this.classManager = null;
		this.refineManager = null;
		this.fortifyManager = null;
		this.identifyManager = null;
		this.soulboundManager = null;
		this.repairManager = null;
		this.dismantleManager = null;
		this.extractorManager = null;
		this.partyManager = null;
		this.itemHintsManager = null;
		this.dropManager = null;
		this.lootManager = null;
		this.sellManager = null;
		this.combatLogManager = null;
	}
	
	@Nullable
	public GemManager getGemManager() {
		return this.gemsManager;
	}
	
	@Nullable
	public EssencesManager getEssenceManager() {
		return this.essencesManager;
	}
	
	@Nullable
	public RuneManager getRuneManager() {
		return this.runesManager;
	}
	
	@Nullable
	public MagicDustManager getMagicDustManager() {
		return this.magicDustManager;
	}
	
	@Nullable
	public ArrowManager getArrowManager() {
		return this.arrowManager;
	}
	
	@Nullable
	public SetManager getSetManager() {
		return this.setManager;
	}
	
	@Nullable
	public ItemGeneratorManager getTierManager() {
		return this.itemGeneratorManager;
	}
	
	@Nullable
	public ClassManager getClassManager() {
		return this.classManager;
	}
	
	@Nullable
	public RefineManager getRefineManager() {
		return this.refineManager;
	}
	
	@Nullable
	public FortifyManager getFortifyManager() {
		return this.fortifyManager;
	}
 	
	@Nullable
	public IdentifyManager getIdentifyManager() {
		return this.identifyManager;
	}
	
	@Nullable
	public SoulboundManager getSoulboundManager() {
		return this.soulboundManager;
	}
	
	@Nullable
	public RepairManager getRepairManager() {
		return this.repairManager;
	}
	
	@Nullable
	public DismantleManager getResolveManager() {
		return this.dismantleManager;
	}
	
	@Nullable
	public ExtractorManager getExtractManager() {
		return this.extractorManager;
	}
	
	@Nullable
	public PartyManager getPartyManager() {
		return this.partyManager;
	}
	
	@Nullable
	public ItemHintsManager getItemHintsManager() {
		return this.itemHintsManager;
	}
	
	@Nullable
	public DropManager getDropManager() {
		return this.dropManager;
	}
	
	@Nullable
	public LootManager getLootManager() {
		return this.lootManager;
	}
	
	@Nullable
	public SellManager getSellManager() {
		return this.sellManager;
	}
	
	@Nullable
	public CombatLogManager getCombatLogManager() {
		return this.combatLogManager;
	}
}