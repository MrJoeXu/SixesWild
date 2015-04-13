/**
 * 
 */
package src.sixeswildgame.world;

/**
 * @author Halsey
 *
 */
public class Tile {
	
	protected int value;
	protected int bonus;
	protected int row;
	protected int column;
	
	protected boolean isSelected;

	/**
	 * @param value
	 * @param bonus
	 * @param row
	 * @param column
	 * @param isSelected
	 */
	public Tile(int value, int bonus, int row, int column, boolean isSelected) {
		super();
		this.value = value;
		this.bonus = bonus;
		this.row = row;
		this.column = column;
		this.isSelected = isSelected;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the isSelected
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * @param isSelected the isSelected to set
	 */
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	

}
