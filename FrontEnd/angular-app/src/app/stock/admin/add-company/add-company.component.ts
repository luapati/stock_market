import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { StockService } from 'src/app/service/stock.service';
import { Company } from '../../company';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {
  company: Company;
  addForm: FormGroup;
  error:string='';
  loader: boolean;
  constructor(private stockService: StockService, private router: Router) { }

  ngOnInit() {
    this.addForm = new FormGroup({
      'id': new FormControl(''),
      'name': new FormControl('', [Validators.required]),
      'turnOver': new FormControl('', [Validators.required, Validators.pattern('^[0-9+]*')]),
      'ceo': new FormControl('', [Validators.required]),
      'briefWriteup': new FormControl(null, [Validators.required]),
      'stockCode': new FormControl(null, [Validators.required]),
    });
  }

  get name() { return this.addForm.get('name'); }
  get turnOver() { return this.addForm.get('turnOver'); }
  get ceo() { return this.addForm.get('ceo'); }
  get briefWriteup() { return this.addForm.get('briefWriteup'); }
  get stockCode() { return this.addForm.get('stockCode'); }

  onSubmitAddForm() {
    this.company = this.addForm.value;
    this.loader=true;
    this.stockService.addCompany(this.company).subscribe((data) => {
      this.router.navigate(['admin'])
    },
    (responseError) => {
      this.error = responseError.error.message;
      this.loader=false;
    }
    );
  }

}


