package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public TrackCoach() {
		
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "just do it:" + fortuneService.getFortune();
	}
	
	public void doMyStartupStuff() {
		System.out.println("TrackCOach: inside method doMyStartupStuff");
	}
	
	public void doMyCleanupStuffYoyo() {
		System.out.println("TrackCoach: inside my doMyCleanupStuffYoyo");
	}

}
