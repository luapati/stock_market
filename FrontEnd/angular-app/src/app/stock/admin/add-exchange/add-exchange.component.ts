import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { StockService } from 'src/app/service/stock.service';
import { Router } from '@angular/router';
import { Exchange } from '../../exchange';

@Component({
  selector: 'app-add-exchange',
  templateUrl: './add-exchange.component.html',
  styleUrls: ['./add-exchange.component.css']
})
export class AddExchangeComponent implements OnInit {
  exchange: Exchange;
  addForm: FormGroup;
  error:string='';
  constructor(private stockService: StockService, private router: Router) { }
  loader: boolean;
  
  
  ngOnInit() {
  
  this.addForm = new FormGroup({
      'id': new FormControl(''),
      'stockExchange': new FormControl('', [Validators.required]),
      'brief': new FormControl('', [Validators.required]),
      'contactAddress': new FormControl('', [Validators.required]),
      'remarks': new FormControl(null, [Validators.required]),
      // 'active' : new FormControl(null, [Validators.required])
    });
  }
  
  
  get stockExchange() { return this.addForm.get('stockExchange'); }
  get brief() { return this.addForm.get('brief'); } 
  get contactAddress() { return this.addForm.get('contactAddress'); }
  get remarks() { return this.addForm.get('remarks'); }
  // get active() { return this.addForm.get('active');}
  
   onSubmitAddForm() {
    this.exchange = this.addForm.value;
    this.loader=true;
    this.stockService.addExchange(this.exchange).subscribe((data) => {
      this.router.navigate(['admin'])
    },
    (responseError) => {
      this.error = responseError.error.message;
      this.loader=false;
    }
    );
  }
}