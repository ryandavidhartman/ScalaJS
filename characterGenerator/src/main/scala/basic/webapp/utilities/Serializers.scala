package basic.webapp.utilities

import basic.fantasy.backgrounds.BackgroundGenerator._
import basic.fantasy.backgrounds.CharacterAlignments._
import basic.fantasy.backgrounds.Races._
import basic.fantasy.characterclass.CharacterClasses._
import basic.fantasy.characterclass.SavingsThrows
import basic.fantasy.equipment.Armors._
import basic.fantasy.equipment.Equipment
import basic.fantasy.equipment.EquipmentPacks._
import basic.fantasy.equipment.MagicalItems._
import basic.fantasy.equipment.MeleeWeapons._
import basic.fantasy.equipment.RangedWeapons._
import basic.fantasy.equipment.Shields._
import basic.webapp.CharacterState


object Serializers {

  implicit val dwarfRW = upickle.default.macroRW[Dwarf.type]
  implicit val elfRW = upickle.default.macroRW[Elf.type]
  implicit val halfElfRW = upickle.default.macroRW[HalfElf.type]
  implicit val halfOrcRW = upickle.default.macroRW[HalfOrc.type]
  implicit val halflingRW = upickle.default.macroRW[Halfling.type]
  implicit val humanRW = upickle.default.macroRW[Human.type]
  implicit val raceRW = upickle.default.macroRW[Race]

  implicit val clericRW = upickle.default.macroRW[Cleric.type]
  implicit val fighterRW = upickle.default.macroRW[Fighter.type]
  implicit val fighterMagicUserRW = upickle.default.macroRW[FighterMagicUser.type]
  implicit val magicUserRW = upickle.default.macroRW[MagicUser.type]
  implicit val magicUserThiefRW = upickle.default.macroRW[MagicUserThief.type]
  implicit val monkRW = upickle.default.macroRW[Monk.type]
  implicit val thiefRW = upickle.default.macroRW[Thief.type]
  implicit val classRW = upickle.default.macroRW[CharacterClass]

  implicit val chaoticRW = upickle.default.macroRW[Chaotic.type]
  implicit val lawfulRW = upickle.default.macroRW[Lawful.type]
  implicit val neutralRW = upickle.default.macroRW[Neutral.type]
  implicit val alignmentRW = upickle.default.macroRW[CharacterAlignment]

  implicit val savingsThrowsRW = upickle.default.macroRW[SavingsThrows]

  implicit val alfheimRW = upickle.default.macroRW[Alfheim.type]
  implicit val alphatiaRW = upickle.default.macroRW[Alphatia.type]
  implicit val altruaghinRW = upickle.default.macroRW[Altruaghin.type]
  implicit val darokinRW = upickle.default.macroRW[Darokin.type]
  implicit val ethengarRW = upickle.default.macroRW[Ethengar.type]
  implicit val fiveShiresRW = upickle.default.macroRW[FiveShires.type]
  implicit val glantriRW = upickle.default.macroRW[Glantri.type]
  implicit val ierendiRW = upickle.default.macroRW[Ierendi.type]
  implicit val karameikosRW = upickle.default.macroRW[Karameikos.type]
  implicit val minrothadRW = upickle.default.macroRW[Minrothad.type]
  implicit val northernReachesRW = upickle.default.macroRW[NorthernReaches.type]
  implicit val rockhomeRW = upickle.default.macroRW[Rockhome.type]
  implicit val shadowLandsRW = upickle.default.macroRW[ShadowLands.type]
  implicit val tharRW = upickle.default.macroRW[Thar.type]
  implicit val thyatisRW = upickle.default.macroRW[Thyatis.type]
  implicit val wildlandsRW = upickle.default.macroRW[Wildlands.type]
  implicit val ylaruamRW = upickle.default.macroRW[Ylaruam.type]
  implicit val nationalityRW = upickle.default.macroRW[Nationality]
  implicit val backgroundRW = upickle.default.macroRW[Background]

  implicit val bandedMailRW = upickle.default.macroRW[BandedMail]
  implicit val brigandineRW = upickle.default.macroRW[Brigandine]
  implicit val chainMailRW = upickle.default.macroRW[ChainMail]
  implicit val fieldPlateMailRW = upickle.default.macroRW[FieldPlateMail]
  implicit val fullPlateMailRW = upickle.default.macroRW[FullPlateMail]
  implicit val hideRW = upickle.default.macroRW[Hide.type]
  implicit val leatherRW = upickle.default.macroRW[Leather]
  implicit val noArmorRW = upickle.default.macroRW[NoArmor.type]
  implicit val paddedRW = upickle.default.macroRW[Padded.type]
  implicit val plateMailRW = upickle.default.macroRW[PlateMail]
  implicit val ringMailRW = upickle.default.macroRW[RingMail]
  implicit val scaleMailRW = upickle.default.macroRW[ScaleMail]
  implicit val splintMailRW = upickle.default.macroRW[SplintMail]
  implicit val studdedRW = upickle.default.macroRW[Studded]
  implicit val armorRW = upickle.default.macroRW[Armor]

  implicit val bucklerRW = upickle.default.macroRW[Buckler]
  implicit val mediumShieldRW = upickle.default.macroRW[MediumShield]
  implicit val noShieldRW = upickle.default.macroRW[NoShield.type]
  implicit val towerShieldRW = upickle.default.macroRW[TowerShield]
  implicit val shieldRW = upickle.default.macroRW[Shield]

  implicit val battleAxeRW = upickle.default.macroRW[BattleAxe]
  implicit val blackjackRW = upickle.default.macroRW[Blackjack]
  implicit val chainRW = upickle.default.macroRW[Chain]
  implicit val clubRW = upickle.default.macroRW[Club]
  implicit val cudgelRW = upickle.default.macroRW[Cudgel]
  implicit val cutlassRW = upickle.default.macroRW[Cutlass]
  implicit val daggerRW = upickle.default.macroRW[Dagger]
  implicit val defendingDaggerRW = upickle.default.macroRW[DefendingDagger]
  implicit val flailRW = upickle.default.macroRW[Flail]
  implicit val footmansPickRW = upickle.default.macroRW[FootmansPick]
  implicit val greatAxeRW = upickle.default.macroRW[GreatAxe]
  implicit val greatClubRW = upickle.default.macroRW[GreatClub]
  implicit val greatFlailRW = upickle.default.macroRW[GreatFlail]
  implicit val greatMaceRW = upickle.default.macroRW[GreatMace]
  implicit val handAxeRW = upickle.default.macroRW[HandAxe]
  implicit val hookRW = upickle.default.macroRW[Hook]
  implicit val lightMaceRW = upickle.default.macroRW[LightMace]
  implicit val longSwordRW = upickle.default.macroRW[LongSword]
  implicit val maceRW = upickle.default.macroRW[Mace]
  implicit val maulRW = upickle.default.macroRW[Maul]
  implicit val militaryPickRW = upickle.default.macroRW[MilitaryPick]
  implicit val morningstarRW = upickle.default.macroRW[Morningstar]
  implicit val poleArmRW = upickle.default.macroRW[PoleArm]
  implicit val quarterStaffRW = upickle.default.macroRW[QuarterStaff]
  implicit val sapRW = upickle.default.macroRW[Sap]
  implicit val scimitarRW = upickle.default.macroRW[Scimitar]
  implicit val scytheRW = upickle.default.macroRW[Scythe]
  implicit val shortSwordRW = upickle.default.macroRW[ShortSword]
  implicit val sickleRW = upickle.default.macroRW[Sickle]
  implicit val silverDaggerRW = upickle.default.macroRW[SilverDagger]
  implicit val spearRW = upickle.default.macroRW[Spear]
  implicit val tridentRW = upickle.default.macroRW[Trident]
  implicit val twoHandedSwordRW = upickle.default.macroRW[TwoHandedSword]
  implicit val unarmedRW = upickle.default.macroRW[Unarmed]
  implicit val walkingStaffRW = upickle.default.macroRW[WalkingStaff]
  implicit val warHammerRW = upickle.default.macroRW[WarHammer]
  implicit val whipRW = upickle.default.macroRW[Whip]
  implicit val meleeWeaponRW = upickle.default.macroRW[MeleeWeapon]

  implicit val arrowRW = upickle.default.macroRW[Arrow]
  implicit val bulletRW = upickle.default.macroRW[Bullet]
  implicit val dartAmmoRW = upickle.default.macroRW[DartAmmo]
  implicit val quarrelRW = upickle.default.macroRW[Quarrel]
  implicit val silverArrowRW = upickle.default.macroRW[SilverArrow]
  implicit val silverBulletRW = upickle.default.macroRW[SilverBullet]
  implicit val silverQuarrelRW = upickle.default.macroRW[SilverQuarrel]
  implicit val stoneRW = upickle.default.macroRW[Stone]
  implicit val ammoRW = upickle.default.macroRW[Ammo]

  implicit val blowgunRW = upickle.default.macroRW[Blowgun]
  implicit val bolaRW = upickle.default.macroRW[Bola]
  implicit val dartRW = upickle.default.macroRW[Dart]
  implicit val handCrossbowRW = upickle.default.macroRW[HandCrossbow]
  implicit val heavyCrossbowRW = upickle.default.macroRW[HeavyCrossbow]
  implicit val javelinRW = upickle.default.macroRW[Javelin]
  implicit val lightCrossbowRW = upickle.default.macroRW[LightCrossbow]
  implicit val longBowRW = upickle.default.macroRW[LongBow]
  implicit val shortBowRW = upickle.default.macroRW[ShortBow]
  implicit val slingRW = upickle.default.macroRW[Sling]
  implicit val throwingKnifeRW = upickle.default.macroRW[ThrowingKnife]
  implicit val rangedWeaponRW = upickle.default.macroRW[RangedWeapon]

  implicit val burglarsPackRW = upickle.default.macroRW[BurglarsPack.type]
  implicit val dungeoneersPackRW = upickle.default.macroRW[DungeoneersPack.type]
  implicit val explorersPackRW = upickle.default.macroRW[ExplorersPack.type]
  implicit val priestsPackRW = upickle.default.macroRW[PriestsPack.type]
  implicit val scholarBurglarsPackRW = upickle.default.macroRW[ScholarBurglarsPack.type]
  implicit val scholarExplorersPackRW = upickle.default.macroRW[ScholarExplorersPack.type]
  implicit val scholarsPackRW = upickle.default.macroRW[ScholarsPack.type]
  implicit val equipmentPackRW = upickle.default.macroRW[EquipmentPack]

  implicit val amuletOfProofAgainstDetectionAndLocationRW = upickle.default.macroRW[AmuletOfProofAgainstDetectionAndLocation.type]
  implicit val bagOfDevouringRW = upickle.default.macroRW[BagOfDevouring.type]
  implicit val bagOfHoldingRW = upickle.default.macroRW[BagOfHolding.type]
  implicit val bootsOfLevitationRW = upickle.default.macroRW[BootsOfLevitation.type]
  implicit val bootsOfSpeedRW = upickle.default.macroRW[BootsOfSpeed.type]
  implicit val bootsOfTravelingAndLeapingRW = upickle.default.macroRW[BootsOfTravelingAndLeaping.type]
  implicit val bowlCommandingWaterElementalsRW = upickle.default.macroRW[BowlCommandingWaterElementals.type]
  implicit val brazierCommandingFireElementalsRW = upickle.default.macroRW[BrazierCommandingFireElementals.type]
  implicit val broomOfFlyingRW = upickle.default.macroRW[BroomOfFlying.type]
  implicit val censerCommandingAirElementalsRW = upickle.default.macroRW[CenserCommandingAirElementals.type]
  implicit val cloakOfDisplacementRW = upickle.default.macroRW[CloakOfDisplacement.type]
  implicit val crystalBallRW = upickle.default.macroRW[CrystalBall.type]
  implicit val crystalBallWithClairaudienceRW = upickle.default.macroRW[CrystalBallWithClairaudience.type]
  implicit val drumsOfPanicRW = upickle.default.macroRW[DrumsOfPanic.type]
  implicit val efreetiBottleRW = upickle.default.macroRW[EfreetiBottle.type]
  implicit val elvenBootsRW = upickle.default.macroRW[ElvenBoots.type]
  implicit val elvenCloakRW = upickle.default.macroRW[ElvenCloak.type]
  implicit val flyingCarpetRW = upickle.default.macroRW[FlyingCarpet.type]
  implicit val gauntletsOfOgrePowerRW = upickle.default.macroRW[GauntletsOfOgrePower.type]
  implicit val girdleOfGiantStrengthRW = upickle.default.macroRW[GirdleOfGiantStrength.type]
  implicit val helmOfReadingLanguagesAndMagicRW = upickle.default.macroRW[HelmOfReadingLanguagesAndMagic.type]
  implicit val helmOfTelepathyRW = upickle.default.macroRW[HelmOfTelepathy.type]
  implicit val helmOfTeleportationRW = upickle.default.macroRW[HelmOfTeleportation.type]
  implicit val hornOfBlastingRW = upickle.default.macroRW[HornOfBlasting.type]
  implicit val hornOfDoomRW = upickle.default.macroRW[HornOfDoom.type]
  implicit val medallionOfESPRW = upickle.default.macroRW[MedallionOfESP.type]
  implicit val mirrorOfLifeTrappingRW = upickle.default.macroRW[MirrorOfLifeTrapping.type]
  implicit val ropeOfClimbingRW = upickle.default.macroRW[RopeOfClimbing.type]
  implicit val scarabOfProtectionRW = upickle.default.macroRW[ScarabOfProtection.type]
  implicit val stoneCommandingEarthElementalsRW = upickle.default.macroRW[StoneCommandingEarthElementals.type]
  implicit val miscellaneousRW = upickle.default.macroRW[Miscellaneous]


  implicit val clairaudienceRW = upickle.default.macroRW[Clairaudience.type]
  implicit val clairvoyanceRW = upickle.default.macroRW[Clairvoyance.type]
  implicit val coldResistanceRW = upickle.default.macroRW[ColdResistance.type]
  implicit val controlAnimalRW = upickle.default.macroRW[ControlAnimal.type]
  implicit val controlDragonRW = upickle.default.macroRW[ControlDragon.type]
  implicit val controlGiantRW = upickle.default.macroRW[ControlGiant.type]
  implicit val controlHumanRW = upickle.default.macroRW[ControlHuman.type]
  implicit val controlPlantRW = upickle.default.macroRW[ControlPlant.type]
  implicit val controlUndeadRW = upickle.default.macroRW[ControlUndead.type]
  implicit val delusionPotionRW = upickle.default.macroRW[DelusionPotion.type]
  implicit val diminutionRW = upickle.default.macroRW[Diminution.type]
  implicit val espRW = upickle.default.macroRW[ESP.type]
  implicit val fireResistanceRW = upickle.default.macroRW[FireResistance.type]
  implicit val flyingRW = upickle.default.macroRW[Flying.type]
  implicit val gaseousFormRW = upickle.default.macroRW[GaseousForm.type]
  implicit val giantStrengthRW = upickle.default.macroRW[GiantStrength.type]
  implicit val growthRW = upickle.default.macroRW[Growth.type]
  implicit val healing = upickle.default.macroRW[Healing.type]
  implicit val heroismRW = upickle.default.macroRW[Heroism.type]
  implicit val invisibilityPotionRW = upickle.default.macroRW[InvisibilityPotion.type]
  implicit val invulnerabilityRW = upickle.default.macroRW[Invulnerability.type]
  implicit val levitationRW = upickle.default.macroRW[Levitation.type]
  implicit val longevityRW = upickle.default.macroRW[Longevity.type]
  implicit val poisonRW = upickle.default.macroRW[Poison.type]
  implicit val speedRW = upickle.default.macroRW[Speed.type]
  implicit val treasureFindingRW = upickle.default.macroRW[TreasureFinding.type]
  implicit val potionRW = upickle.default.macroRW[Potion]

  implicit val animalControlRW = upickle.default.macroRW[AnimalControl.type]
  implicit val delusionRW = upickle.default.macroRW[Delusion.type]
  implicit val djinniSummoningRW = upickle.default.macroRW[DjinniSummoning.type]
  implicit val earRW = upickle.default.macroRW[Ear.type]
  implicit val elementalAdaptationRW = upickle.default.macroRW[ElementalAdaptation.type]
  implicit val fireResistanceRingRW = upickle.default.macroRW[FireResistanceRing.type]
  implicit val holinessRW = upickle.default.macroRW[Holiness.type]
  implicit val humanControlRW = upickle.default.macroRW[HumanControl.type]
  implicit val invisibilityRW = upickle.default.macroRW[Invisibility.type]
  implicit val lifeProtectionRW = upickle.default.macroRW[LifeProtection.type]
  implicit val memoryRW = upickle.default.macroRW[Memory.type]
  implicit val plantControlRW = upickle.default.macroRW[PlantControl.type]
  implicit val protectionRW = upickle.default.macroRW[Protection]
  implicit val quicknessRW = upickle.default.macroRW[Quickness.type]
  implicit val ringRW = upickle.default.macroRW[Ring]

  implicit val magicItemRW = upickle.default.macroRW[MagicItem]

  implicit val equipmentRW = upickle.default.macroRW[Equipment]

  implicit val stateRW =  upickle.default.macroRW[CharacterState]

}
