import { Component, OnInit } from '@angular/core';
import { ProductService } from './../product.service';
import { Product } from './../product-model';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  Produto: Product={
    value:0,
    name:''

  }

  constructor(private Pservice:ProductService) { }

  ngOnInit(): void {
   
  }
  Cancel():void{
    this.Pservice.BackHomePage("/products");
  }
  PopSnack():void{
    this.Pservice.Popup("Cadastrado com sucesso!")
  
  }
  Create():void{
    this.Produto.value=Number(this.Produto.value)
    console.log(typeof(this.Produto.value))
    this.Pservice.create(this.Produto).subscribe(()=>{
      this.Pservice.Popup("Cadastrado com sucesso!")
      this.Pservice.BackHomePage("/products");
    });
  }
}
