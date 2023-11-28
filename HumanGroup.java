package pack;

import java.util.Comparator;

public class HumanGroup {
	public long Population;
	public int Age;
	public int YearsAsApprentice;
	public int YearsInTeaching;
	public boolean IsDisciple;
	public boolean IsApprentice;
	
	public HumanGroup() {
		this.Population = 0;
		this.Age = 0;
		this.YearsAsApprentice = 0;
		this.YearsInTeaching = 0;
		this.IsDisciple = false;
		this.IsApprentice = false;
	}
	
	
	public void Aging() {
		this.Age += 1;
		if (this.IsApprentice) {
			this.YearsAsApprentice += 1;
		}
		if (this.IsDisciple) {
			this.YearsInTeaching++;
		}
	}
	
	public boolean CanBeApprentice() {
		return this.Age >= Human.YearToBeDisciple;
	}
	
	public boolean CanBeDisciple() {
		return this.IsApprentice && this.YearsAsApprentice >= Human.YearToBeDisciple;
	}
	
	public boolean IsGivingBirth() {
		return this.Age == Human.AgeOfGivingBirth;
	}
	
	public boolean CanTrainDisciple() {
		return this.IsDisciple
				&&
				this.YearsInTeaching == Human.YearToBeDisciple;
	}
	
	public boolean IsDea() {
		return this.Age >= Human.MaxAge;
	}

	public HumanGroup Clone() {
		HumanGroup hg = new HumanGroup();
		hg.Age = this.Age;
		hg.Population = this.Population;
		hg.YearsAsApprentice = this.YearsAsApprentice;
		hg.YearsInTeaching = this.YearsInTeaching;
		hg.IsDisciple = this.IsDisciple;
		hg.IsApprentice = this.IsApprentice;
		return hg;
	}

	public static Comparator<HumanGroup> ageAscComparator = new Comparator<HumanGroup>() {
		public int compare(HumanGroup o1, HumanGroup o2) {
			if (o1.Age > o2.Age) {
				return 1;
			} else if (o1.Age == o2.Age) {
				return 0;
			} else {
				return -1;
			}
		}
	};
}