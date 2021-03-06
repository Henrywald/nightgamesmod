package nightgames.skills;

import nightgames.characters.Attribute;
import nightgames.characters.Character;
import nightgames.characters.Trait;
import nightgames.combat.Combat;
import nightgames.combat.Result;
import nightgames.global.Global;
import nightgames.items.Item;
import nightgames.stance.Stance;

public class VibroTease extends Skill {

	public VibroTease(Character self) {
		super("Vibro-Tease", self);
	}

	@Override
	public boolean requirements(Combat c, Character user, Character target) {
		return user.has(Item.Strapon2);
	}

	@Override
	public boolean usable(Combat c, Character target) {
		return getSelf().canAct()&&c.getStance().dom(getSelf())&&(c.getStance().en==Stance.anal)&&getSelf().has(Trait.strapped)&&c.getStance().inserted(getSelf())&&getSelf().has(Item.Strapon2);
	}

	@Override
	public String describe(Combat c) {
		return "Turn up the strapon vibration";
	}

	@Override
	public boolean resolve(Combat c, Character target) {
		if(getSelf().human()){
			c.write(getSelf(),deal(c,0,Result.normal, target));
		}
		else{
			if(target.human()){
				c.write(getSelf(),receive(c,0,Result.normal, target));
			}
		}
		int m = 10 + Global.random(5);
		target.body.pleasure(getSelf(), null, target.body.getRandom("ass"), m, c);
		getSelf().arouse(2, c);
		return true;
	}

	@Override
	public int getMojoBuilt(Combat c) {
		return 15;
	}
	@Override
	public Skill copy(Character user) {
		return new VibroTease(user);
	}

	@Override
	public Tactics type(Combat c) {
		return Tactics.pleasure;
	}

	@Override
	public String deal(Combat c, int damage, Result modifier, Character target) {
		return "";
	}

	@Override
	public String receive(Combat c, int damage, Result modifier, Character target) {
		return getSelf().name()+" cranks up the vibration to maximum level which stirs up your insides. " +
				"She teasingly pokes the tip against your prostate which causes your limbs to get shaky from the pleasure.";
	}

	@Override
	public boolean makesContact() {
		return true;
	}
}
