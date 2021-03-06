package vn.aptech.project4.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ingredient")
public class Ingredient {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ingredient_name")
	private String ingredientName;
	@Column(name="UMO")
	private String uMO;
	/*
	 * @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
	 * CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	 * 
	 * @JoinTable(name="product_ingredient", joinColumns
	 * = @JoinColumn(name="ingredient_id"),inverseJoinColumns
	 * = @JoinColumn(name="product_id")) private List<Product> products;
	 */
	@OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
	private List<ProductIngredient> productIngredients = new ArrayList<>();
	@OneToOne
	@JoinColumn(name="id")
	private Inventory inventory;

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", ingredientName=" + ingredientName + ", UMO=" + uMO
				+ "]";
	}

	public Ingredient() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getuMO() {
		return uMO;
	}

	public void setuMO(String uMO) {
		this.uMO = uMO;
	}

	public List<ProductIngredient> getProductIngredients() {
		return productIngredients;
	}

	public void setProductIngredients(List<ProductIngredient> productIngredients) {
		this.productIngredients = productIngredients;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
