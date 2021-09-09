package tv;

public class TV {
	private int channel;	// 1~255
	private int volume;		// 0~100
	private boolean power;
	
	/* 초기값 설정 생성자 */
	public TV(int channel, int volume, boolean power) {
		channel(channel);
		volume(volume);
		power(power);
	}
	public TV(int channel, boolean volume, boolean power) {
		channel(channel);
		volume(volume);
		power(power);
	}
	public TV(boolean channel, int volume, boolean power) {
		channel(channel);
		volume(volume);
		power(power);
	}
	public TV(boolean channel, boolean volume, boolean power) {
		channel(channel);
		volume(volume);
		power(power);
	}
	
	/* TV 정보 출력 */
	public void status() {
		String printPower;
		if(power) {
			printPower = "on";
		} else {
			printPower = "off";
		}
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + printPower + "]");
	}
	
	/* TV 전원(true - on, false - off */
	public void power(boolean on) {
		power = on;
	}
	
	/* 채널 설정 */
	public void channel(int channel) {
		if(channel>0 && channel<256) {
			this.channel = channel;
		} else {
			System.out.println("1~255 채널만 입력할 수 있습니다.");
		}
	}
	public void channel(boolean up) {
		// channel(channel + (up ? 1: -1));
		if(up) {
			this.channel++;
			
			if(this.channel > 255) {
				this.channel = 1;
			}
		} else {
			this.channel--;
			
			if(this.channel < 1) {
				this.channel = 255;
			}
		}
	}
	
	/* 볼륨 설정 */
	public void volume(int volume) {
		if(volume>-1 && volume<101) {
			this.volume = volume;
		} else {
			System.out.println("볼륨은 0~100 범위 내에서 설정할 수 있습니다.");
		}
	}
	public void volume(boolean up) { 
		if(up && this.volume < 100) {
			this.volume++;
		} else if(!up && this.volume > 0) {
			this.volume--;
		}
	}
}
