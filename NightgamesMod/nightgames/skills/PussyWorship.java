package nightgames.skills;

import java.util.Optional;

import nightgames.characters.Attribute;
import nightgames.characters.Character;
import nightgames.characters.Trait;
import nightgames.combat.Combat;
import nightgames.combat.Result;
import nightgames.global.Global;
import nightgames.stance.ReverseMount;
import nightgames.stance.SixNine;
import nightgames.stance.Stance;
import nightgames.status.BodyFetish;
import nightgames.status.CockBound;
import nightgames.status.Stsflag;
import nightgames.status.Trance;

public class PussyWorship extends Skill {

	public PussyWorship(Character self) {
		super("Pussy Worship", self);
	}

	@Override
	public boolean usable(Combat c, Character target) {
		return (target.crotchAvailable()&&target.hasDick()&&c.getStance().oral(getSelf())&&c.getStance().front(getSelf())&&getSelf().canAct()&&!c.getStance().vaginallyPenetrated(target));
	}

	@Override
	public float priorityMod(Combat c) {
		return 0;
	}

	@Override
	public int getMojoBuilt(Combat c) {
		return 0;
	}

	@Override
	public boolean resolve(Combat c, Character target) {
		int m = 10 + Global.random(8);
		if(getSelf().has(Trait.silvertongue)){
			m += 4;
		}
		if(target.human()){
			c.write(getSelf(),receive(c,m,Result.normal, target));
		}
		else if(getSelf().human()){
			c.write(getSelf(),deal(c,m,Result.normal, target));
		}
		target.body.pleasure(getSelf(), getSelf().body.getRandom("mouth"), target.body.getRandom("pussy"), m, c);
		if (getSelf().hasDick() && (!getSelf().hasPussy() || Global.random(2) == 0)) {
			getSelf().body.pleasure(getSelf(), getSelf().body.getRandom("hands"), getSelf().body.getRandomCock(), m, c);
		} else if (getSelf().hasPussy()){
			getSelf().body.pleasure(getSelf(), getSelf().body.getRandom("hands"), getSelf().body.getRandomPussy(), m, c);
		} else {
			getSelf().body.pleasure(getSelf(), getSelf().body.getRandom("hands"), getSelf().body.getRandomHole(), m, c);	
		}

		target.buildMojo(c, 20);
		return true;
	}

	@Override
	public boolean requirements(Combat c, Character user, Character target) {
		Optional<BodyFetish> fetish = getSelf().body.getFetish("pussy");
		return fetish.isPresent() && fetish.get().magnitude >= .5;
	}

	public int accuracy(Combat c){
		return 150;
	}
	@Override
	public Skill copy(Character user) {
		return new PussyWorship(user);
	}
	public int speed(){
		return 2;
	}

	@Override
	public Tactics type(Combat c) {
		return Tactics.pleasure;
	}

	@Override
	public String deal(Combat c, int damage, Result modifier, Character target) {
		return Global.format("You ecstatically crawl towards {other:name-do} and bring your face up to {other:possessive} {other:body-part:pussy}. "
				+ "You carefully form a seal with your mouth and {other:possessive} netherlips, and stick your tongue into {other:possessive} moist slit. "
				+ "Minutes pass and you lose yourself alternating between tonguing {other:name-possessive} divine cunt while idly playing with yourself and "
				+ "sucking on {other:possessive} fleshy nib. Finally, {other:subject} "
				+ "pushes your head away from {other:possessive} drentched hole and you finally regain your senses.", getSelf(), target);
	}

	@Override
	public String receive(Combat c, int damage, Result modifier, Character target) {
		return Global.format("{self:subject} ecstatically crawls to you on {self:possessive} knees and attaches {self:possessive} {self:body-part:mouth} to "
				+ "{other:possessive} {other:body-part:pussy} while holding onto your legs. {self:SUBJECT} carefully takes a few licks of {other:possessive} slit before "
				+ "diving right in with her tongue to eat you out. Minutes pass and {self:subject} continues {self:possessive} attack on your cunt while idly playing with "
				+ "{self:reflective}. Feeling a bit too good, you manage to push {self:name-do} away from your sensitive womanhood lest she makes you cum accidentally.", getSelf(), target);
		}

	@Override
	public String describe(Combat c) {
		return "Worship your opponent's pussy";
	}

	@Override
	public boolean makesContact() {
		return true;
	}
}
