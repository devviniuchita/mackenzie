import { Controller, Get, Param } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get(':value/:fromCurrency/:toCurrency/:rate')
  convert(
    @Param('value') value: string,
    @Param('fromCurrency') fromCurrency: string,
    @Param('toCurrency') toCurrency: string,
    @Param('rate') rate: string,
  ): string {
    const numericValue = parseFloat(value);
    const numericRate = parseFloat(rate);

    if (isNaN(numericValue)) {
      throw new Error('Valor deve ser um número');
    }

    if (isNaN(numericRate) || numericRate <= 0) {
      throw new Error('Cotação deve ser um número positivo');
    }

    return this.appService.convertCurrency(
      numericValue,
      fromCurrency,
      toCurrency,
      numericRate,
    );
  }
}
