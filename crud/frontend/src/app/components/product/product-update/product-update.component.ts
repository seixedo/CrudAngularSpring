import { Component, OnInit } from '@angular/core';
import { ProductService } from './../product.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Product } from './../product-model';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  Produto: Product={
    id:0,
    value:0,
    name:''

  }
  constructor(private productService:ProductService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    const id= String(this.route.snapshot.paramMap.get('id'));

    this.productService.getById(id).subscribe(Produto=>{
      this.Produto=Produto
    });
  }
  updateProduct():void{
    console.log(this.Produto)
    this.productService.update(this.Produto).subscribe(()=>
    {
      this.productService.Popup("Produto Atualizado com sucesso!")
      this.router.navigate(['/products'])
    })
    
  }
  Cancel():void{
    this.router.navigate(['/products'])
  }
}
