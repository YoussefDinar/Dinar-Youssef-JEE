import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {ProductService} from "../services/product.service";
import {Product} from "../model/product.model";
import {observable, Observable} from "rxjs";
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{
  public products : Array<Product> =[];
  public keyword : string="";
  constructor(private productService:ProductService) {
  }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(){

    this.productService.getProducts(0,10)
      .subscribe({
        next : data => {
          this.products = data
        },
        error : err =>{
          console.log(err)
        }
      })

    //this.products$ = this.productService.getProducts();
  }

  handleCheckProduct(product: Product) {
    this.productService.checkProduct(product).
    subscribe({
      next : updatedProduct => {
        product.checked=!product.checked;
        //this.getProducts(;
      }
    })
  }

  handleDelete(product: Product) {
    if (confirm("Are you sure?"))
      this.productService.deleteProducts(product).subscribe({
        next : value => {
          //this.getProducts();
          this.products = this.products.filter(p => p.id != product.id)
        }
      });
  }

  searchProducts() {
    this.productService.searchProducts(this.keyword).subscribe({
      next : value => {
        this.products = value;
      }
    })
  }

}
