public enum DifficultyTag {
		EASY("easy"), MEDIUM("medium"), HARD("hard");

		private final String diffTag;
		DifficultyTag(String tag){
			this.diffTag = tag;
		}
		public String getDiffTag(){
			return diffTag;
		}
}
