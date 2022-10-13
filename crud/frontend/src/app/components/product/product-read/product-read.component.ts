import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Product } from './../product-model';
import { ProductService } from './../product.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { MatSort, Sort } from '@angular/material/sort';

@Component({
  selector: 'app-product-read',
  templateUrl: './product-read.component.html',
  styleUrls: ['./product-read.component.css']
})

export class ProductReadComponent implements OnInit,AfterViewInit{
displayedColumns: string[]=['id','name','value','inserido','alterado','actions']
products: Product[] =[]
dataSource=new MatTableDataSource<Product>(this.products);

@ViewChild(MatPaginator) paginator!: MatPaginator;
@ViewChild(MatSort) sort!: MatSort;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.read().subscribe(products =>{
      this.dataSource = new MatTableDataSource<Product>(products)
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      var arrAlterado
      arrAlterado = this.dataSource.data[0].alterado.split("")
      console.log(arrAlterado)

    
    })
  }
  ngAfterViewInit(): void {
    
  }

  
  
  

}
